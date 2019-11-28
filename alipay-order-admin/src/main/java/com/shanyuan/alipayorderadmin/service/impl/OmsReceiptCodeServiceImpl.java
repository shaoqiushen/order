package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dao.CmsReceiptCodeDao;
import com.shanyuan.alipayorderadmin.dao.OmsReceiptCodeDao;
import com.shanyuan.alipayorderadmin.dto.*;
import com.shanyuan.alipayorderadmin.service.OmsReceiptCodeService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.CmsReceiptCodeMapper;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.CmsReceiptCode;
import com.shanyuan.model.CmsReceiptCodeExample;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 10:46
 * <p>
 * desc
 **/
@Service
public class OmsReceiptCodeServiceImpl implements OmsReceiptCodeService {

    @Autowired
    OmsReceiptCodeDao omsReceiptCodeDao;

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    CmsReceiptCodeMapper cmsReceiptCodeMapper;

    @Autowired
    CmsReceiptCodeDao cmsReceiptCodeDao;


    @Override
    public PageInfo<OmsReceiptCodeResult> listReceiptCode(Integer pageNum, Integer pageSize, OmsReceiptQueryParams params) {
        PageHelper.startPage( pageNum,pageSize );
        List <OmsReceiptCodeResult> omsReceiptCodeResults=omsReceiptCodeDao.listReceiptCode( params );
        PageInfo<OmsReceiptCodeResult> pageInfo = new PageInfo <>( omsReceiptCodeResults );
        return pageInfo;
    }

    @Override
    public PageInfo <OmsOrder> listOrderByDeskNo(Long brandId, Integer pageNum, Integer pageSize, String deskNo) {
        PageHelper.startPage( pageNum,pageSize );
        OmsOrderExample example = new OmsOrderExample();
        example.setOrderByClause( "id desc" );
        example.createCriteria().andBrandIdEqualTo( brandId )
                .andDeskNoEqualTo( deskNo ).andPaymentTimeIsNotNull();
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        PageInfo<OmsOrder> pageInfo = new PageInfo <>( omsOrders );
        return pageInfo;
    }

    @Override
    public CommonResult createReceiptCode(CmsReceiptCodeParams params) {
        //查询桌号是否存在,且不是本身
        if(checkDeskNoExist(0,params.getDeskNo(),params.getStoreId())){
            return new CommonResult().failed( "编号已经存在" );
        }
        CmsReceiptCode cmsReceiptCode = new CmsReceiptCode();
        BeanUtils.copyProperties( params,cmsReceiptCode );
        cmsReceiptCode.setCreateTime( new Date(  ) );
        int count=cmsReceiptCodeMapper.insert( cmsReceiptCode );
        return ResultUtil.result( count );
    }

    @Override
    public CommonResult updateReceiptCode(Integer id, CmsReceiptCodeParams params) {
        //查询桌号是否存在,且不是本身
        if(checkDeskNoExist(id,params.getDeskNo(),params.getStoreId())){
            return new CommonResult().failed( "编号已经存在" );
        }
        CmsReceiptCode cmsReceiptCode = new CmsReceiptCode();
        BeanUtils.copyProperties( params,cmsReceiptCode );
        cmsReceiptCode.setId( id );
        int count=cmsReceiptCodeMapper.updateByPrimaryKeySelective( cmsReceiptCode );
        return ResultUtil.result( count );
    }

    @Override
    public PageInfo <CmsReceiptCodeResult> listReceiptCodeByStoreId(Integer storeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
//        CmsReceiptCodeExample example = new CmsReceiptCodeExample();
//        example.setOrderByClause( "desk_no asc" );
//        example.createCriteria().andStoreIdEqualTo( storeId );
//        List <CmsReceiptCode> cmsReceiptCodes=cmsReceiptCodeMapper.selectByExample( example );
        List <CmsReceiptCodeResult> cmsReceiptCodeResults=cmsReceiptCodeDao.listReceiptCodeByStoreId( storeId );
        PageInfo<CmsReceiptCodeResult> pageInfo = new PageInfo <>( cmsReceiptCodeResults );
        return pageInfo;
    }

    @Override
    public int deleteReceiptCode(Integer id) {
        return cmsReceiptCodeMapper.deleteByPrimaryKey( id );
    }

    @Override
    public CmsReceiptCode getReceiptCodeInfo(String deskNo, Integer storeId) {
        CmsReceiptCodeExample example = new CmsReceiptCodeExample();
        example.createCriteria().andStoreIdEqualTo( storeId ).andDeskNoEqualTo( deskNo );
        List <CmsReceiptCode> cmsReceiptCodes=cmsReceiptCodeMapper.selectByExample( example );
        if(cmsReceiptCodes.size() > 0){
            return cmsReceiptCodes.get( 0 );
        }
        return null;
    }

    @Override
    public PageInfo <CmsReceiptCode> listDeskNo(Long brandId, Integer storeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        CmsReceiptCodeExample receiptCodeExample = new CmsReceiptCodeExample();
        receiptCodeExample.createCriteria().andBrandIdEqualTo( brandId )
                .andStoreIdEqualTo( storeId );
        receiptCodeExample.setOrderByClause( "desk_no asc" );
        List <CmsReceiptCode> cmsReceiptCodes=cmsReceiptCodeMapper.selectByExample( receiptCodeExample );
        PageInfo<CmsReceiptCode> pageInfo = new PageInfo <>( cmsReceiptCodes );
        return pageInfo;
    }

    @Override
    public int countCode(Long brandId, Integer storeId) {
        CmsReceiptCodeExample example = new CmsReceiptCodeExample();
        CmsReceiptCodeExample.Criteria criteria=example.createCriteria();
        criteria.andBrandIdEqualTo( brandId );
        if(storeId !=-1){
            criteria.andStoreIdEqualTo( storeId );
        }
        return cmsReceiptCodeMapper.countByExample( example );
    }

    @Override
    public PageInfo <CmsReceiptCodeRes> listReceiptCodeByParams(BrandStoreParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        List <CmsReceiptCodeRes> cmsReceiptCodeRes=cmsReceiptCodeDao.listReceiptCodeByParams( params );
        PageInfo<CmsReceiptCodeRes> pageInfo = new PageInfo <>( cmsReceiptCodeRes );
        return pageInfo;
    }

    private Boolean checkDeskNoExist(Integer id,String deskNo,Integer storeId){
        CmsReceiptCode receiptCodeInfo=getReceiptCodeInfo( deskNo, storeId);
        if(receiptCodeInfo !=null){
            if(receiptCodeInfo.getId() != id && id !=0){
                return true;
            }
        }
        return false;
    }
}
