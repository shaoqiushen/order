package com.shanyuan.alipayorderportal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.config.ServerConfig;
import com.shanyuan.alipayorderportal.domain.ServerResponse;
import com.shanyuan.alipayorderportal.dto.PortalObtainPhoneParams;
import com.shanyuan.alipayorderportal.dto.PortalUserAddressParams;
import com.shanyuan.alipayorderportal.dto.PortalUserAuthorizationParams;
import com.shanyuan.alipayorderportal.service.PortalUserService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.common.service.UserService;
import com.shanyuan.common.utils.GeneratorKeyUtil;
import com.shanyuan.common.utils.HttpUtils;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.UmsAddressMapper;
import com.shanyuan.mapper.UmsUserMapper;
import com.shanyuan.model.UmsAddress;
import com.shanyuan.model.UmsAddressExample;
import com.shanyuan.model.UmsUser;
import com.shanyuan.model.UmsUserExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:44
 * <p>
 * desc
 **/
@Service
public class PortalUserServiceImpl implements PortalUserService {

    @Autowired
    UmsAddressMapper umsAddressMapper;

    @Autowired
    UserService userService;

    @Autowired
    UmsUserMapper umsUserMapper;

    @Autowired
    ServerConfig serverConfig;

    @Autowired
    PortalUserService portalUserService;


    @Override
    public CommonResult createUserAddress(PortalUserAddressParams params) {
        UmsAddress umsAddress=new UmsAddress();
        BeanUtils.copyProperties( params, umsAddress );
//        UmsUser userInfo=portalUserService.getUserInfo( params.getUserId() );
//        if(userInfo == null){
//            return new CommonResult().error( ExceptionEnum.USER_NOT_EXISTS );
//        }
        //查询经纬度
//        Map <String, Double> map=BaiduUtil.getLngAndLat( params.getArea() + params.getAddress() );
//        Double lng=map.get( "lng" );
//        Double lat=map.get( "lat" );
        umsAddress.setLongitude( params.getLongitude() );
        umsAddress.setLatitude( params.getLatitude() );
        int count = 0;
        if (params.getType() == 1) {
            //假如新建的地址被设置为默认地址、、则将之前的地址全部设置为非默认地址
            UmsAddressExample example=new UmsAddressExample();
            UmsAddress address=new UmsAddress();
            address.setType( 0 );
            example.createCriteria().andUserIdEqualTo( params.getUserId() ).andTypeEqualTo( 1 );
            count = umsAddressMapper.updateByExampleSelective( address, example );
        }
        count = umsAddressMapper.insertSelective( umsAddress );
        if(count < 1){
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new DescribeException( ExceptionEnum.CREATE_USER_ADDR_ERROR );
        }
        return ResultUtil.result( count );
    }

    @Override
    public PageInfo <UmsAddress> listUserAddress(Integer pageNum, Integer pageSize, String userId) {
        List <UmsAddress> umsAddresses=userService.listUserAddress( pageNum, pageSize, userId );
        PageInfo <UmsAddress> pageInfo=new PageInfo <>( umsAddresses );
        return pageInfo;
    }

    @Override
    public int deleteUserAddress(Integer id) {
        return umsAddressMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int updateUserAddress(Integer id, PortalUserAddressParams params) {
        UmsAddress umsAddress=new UmsAddress();
        BeanUtils.copyProperties( params, umsAddress );
        umsAddress.setId( id );
        return umsAddressMapper.updateByPrimaryKeySelective( umsAddress );
    }

    @Override
    public UmsAddress getUserAddr(Integer id) {
        return umsAddressMapper.selectByPrimaryKey( id );
    }

    @Override
    public CommonResult obtainPhone(PortalObtainPhoneParams prams) {
        StringBuffer stringBuffer = new StringBuffer(  );
        stringBuffer.append( "app="+"2001" )
                .append( "&appid="+prams.getAppid() )
                .append( "&encryptedData="+JSONObject.toJSONString( prams.getEncryptedData() ) );
        String response=HttpUtils.getResponse( serverConfig.getServeraddr() + "/user/getphone", stringBuffer.toString() );
        ServerResponse serverResponse = JSONObject.parseObject( response,ServerResponse.class );
        if(serverResponse.getStatus() == 1){
            return new CommonResult().success( serverResponse.getData() );
        }
        return new CommonResult().failed( "获取手机号失败:"+serverResponse.getMsg() );
    }

    @Override
    public CommonResult authorization(PortalUserAuthorizationParams params) {
        Map <String, String> map=new HashMap <>();
        //获取支付宝userid
        String alipayUserId=getAlipayUserId( params.getCode(),String.valueOf( params.getBrandId() ) );

        //先通过aliuserid查询此用户是否已经存在
        UmsUser userInfoByAliId=getUserInfoByAliId( alipayUserId,params.getBrandId() );
        if (userInfoByAliId != null) {
            //若存在则直接返回
            map.put( "userId", userInfoByAliId.getUserId() );
            return new CommonResult().success( map );
        } else {
            //不存在则入库
            String uid=GeneratorKeyUtil.getUid();
            UmsUser umsUser=new UmsUser();
            BeanUtils.copyProperties( params, umsUser );
            umsUser.setUserId( uid );
            umsUser.setAliUserId( Long.parseLong( alipayUserId ) );
            umsUser.setBrandId( params.getBrandId() );
            int count=umsUserMapper.insertSelective( umsUser );
            map.put( "userId", uid );
            if (count > 0) {
                return new CommonResult().success( map );
            }
        }
        return new CommonResult().failed( "用户授权登录失败" );
    }

    @Override
    public UmsUser getUserInfo(String userId) {
        UmsUserExample example=new UmsUserExample();
        example.createCriteria().andUserIdEqualTo( userId );
        List <UmsUser> umsUsers=umsUserMapper.selectByExample( example );
        if (umsUsers.size() == 0) {
            return null;
        }
        return umsUsers.get( 0 );
    }

    @Override
    public UmsUser getUserInfoByAliId(String aliUserId,Long brandId) {
        UmsUserExample userExample=new UmsUserExample();
        userExample.createCriteria().andAliUserIdEqualTo( Long.parseLong( aliUserId ) ).andBrandIdEqualTo( brandId );
        List <UmsUser> umsUsers=umsUserMapper.selectByExample( userExample );
        if (umsUsers.size() > 0) {
            return umsUsers.get( 0 );
        }
        return null;
    }

    @Override
    public int updatePhone(String userId,String telephone) {
        UmsUserExample example = new UmsUserExample();
        example.createCriteria().andUserIdEqualTo( userId );
        UmsUser umsUser = new UmsUser();
        umsUser.setTelephone( telephone );
        return umsUserMapper.updateByExampleSelective( umsUser,example );
    }

    @Override
    public boolean userExists(String userId) {
        UmsUserExample example=new UmsUserExample();
        example.createCriteria().andUserIdEqualTo( userId );
        List <UmsUser> umsUsers=umsUserMapper.selectByExample( example );
        if (umsUsers.size() == 0) {
            return false;
        }
        return true;
    }

    public String getAlipayUserId(String code,String appid) {
        String aliUserId="";
        ServerResponse result;
        try {
            StringBuffer sb=new StringBuffer();
            sb.append( "code=" + code ).append( "&app=" + "2001" ).append( "&type=" + 1 ).append( "&appid="+appid );
            String response=HttpUtils.getResponse( serverConfig.getServeraddr()+"/user/getuserid", sb.toString() );
            result=JSONObject.parseObject( response, ServerResponse.class );
        } catch ( Exception e ) {
            throw new DescribeException( ExceptionEnum.GET_ALI_USERINFO_ERROR );
        }
        if (result.getStatus() == 1) {
            aliUserId=( String ) result.getData();
        } else {
            throw new DescribeException( 20000, result.getMsg() );
        }
        return aliUserId;
    }
}
