package com.shanyuan.alipayorderadmin.service.impl;

import com.shanyuan.alipayorderadmin.service.CmsCodeService;
import com.shanyuan.mapper.CmsCodeScanMapper;
import com.shanyuan.model.CmsCodeScan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 17:55
 * <p>
 * desc
 **/
@Service
@Slf4j
public class CmsCodeServiceImpl implements CmsCodeService {

    @Autowired
    CmsCodeScanMapper cmsCodeScanMapper;

    @Override
    public int createCode(Long brandId,Integer storeId,String deskNo, HttpServletResponse response) {
        //调用服务
        //TODO
        // 2. 转发到支付宝小程序
        CmsCodeScan cmsCodeScan=null;
        try {
            //记录扫描记录
            cmsCodeScan=new CmsCodeScan();
            cmsCodeScan.setBrandId( brandId );
            cmsCodeScan.setStoreId( storeId );
            cmsCodeScan.setDeskNo( deskNo );
            cmsCodeScan.setCreateTime( new Date() );
            cmsCodeScan.setStatus( 1 );
            response.sendRedirect( "alipays://platformapi/startapp?appId=" + brandId + "&page=pages%2Fmeal-list%2Fmeal-list&query=storeId%3D" + storeId + "%26tNo=" + deskNo );
        } catch ( IOException e ) {
            log.error( "sendRedirect error{}", e );
            cmsCodeScan.setStatus( 0 );
            return 0;
        } finally {
            cmsCodeScanMapper.insert( cmsCodeScan );
        } return 1;
    }
}
