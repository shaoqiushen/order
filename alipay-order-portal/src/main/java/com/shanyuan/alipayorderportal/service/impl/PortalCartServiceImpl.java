package com.shanyuan.alipayorderportal.service.impl;

import com.shanyuan.alipayorderportal.dao.PortalCartDao;
import com.shanyuan.alipayorderportal.domain.CartParam;
import com.shanyuan.alipayorderportal.dto.PortalCartParams;
import com.shanyuan.alipayorderportal.service.PortalCartService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.OmsCartMapper;
import com.shanyuan.mapper.PmsItemMapper;
import com.shanyuan.model.OmsCart;

import com.shanyuan.model.OmsCartExample;
import com.shanyuan.model.PmsItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 17:05
 * <p>
 * desc
 **/
@Service
@Slf4j
public class PortalCartServiceImpl implements PortalCartService {

    @Autowired
    OmsCartMapper omsCartMapper;

    @Autowired
    PortalCartDao portalCartDao;

    @Autowired
    PmsItemMapper pmsItemMapper;

    @Override
    public CommonResult createCart(PortalCartParams params) {
        try {
            List<OmsCart> cartList = new ArrayList <>(  );
            if(params.getCartParamList().size() == 0){
                return new CommonResult().failed( "购物车无产品" );
            }
            //判断商品是否存在
            for(CartParam cartParam: params.getCartParamList()){
                PmsItem pmsItem=pmsItemMapper.selectByPrimaryKey( cartParam.getItemId() );
                if(pmsItem == null){
                    return new CommonResult().failed( "商品id:"+cartParam.getItemId()+"不存在" );
                }
                OmsCart cart=new OmsCart();
                BeanUtils.copyProperties( params, cart );
                BeanUtils.copyProperties( cartParam,cart );
                cart.setCreateTime( new Date() );
                cartList.add( cart );
            }
//            OmsCart cart=new OmsCart();
//            BeanUtils.copyProperties( params, cart );
//            cartList.add( cart );
            int count=portalCartDao.createCart( cartList );
            return ResultUtil.result( count );
        } catch ( Exception e ) {
            log.error( "createCart error{}",e );
            throw new DescribeException( ExceptionEnum.CREATE_CART_ERROR );
        }

    }

    @Override
    public List <OmsCart> getCartInfo(Long brandId, String userId) {
        List <OmsCart> omsCarts;
        try {
            OmsCartExample cartExample=new OmsCartExample();
            cartExample.setOrderByClause( "id desc" );
            cartExample.createCriteria().andUserIdEqualTo( userId ).andBrandIdEqualTo( brandId );
            omsCarts=omsCartMapper.selectByExample( cartExample );
        } catch ( Exception e ) {
            throw new DescribeException( ExceptionEnum.QUERY_ERROR );
        }
        return omsCarts;
    }

    @Override
    public int deleteCart(List<Integer> ids) {
        OmsCartExample example = new OmsCartExample();
        example.createCriteria().andIdIn( ids );
        return omsCartMapper.deleteByExample( example );
    }
}
