package com.shanyuan.alipayorderadmin.controller;

import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-23 10:29
 * <p>
 * desc
 **/
@Api(value="OssController",description="图片上传管理")
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    UploadService uploadService;

    @ApiOperation( "图片上传" )
    @PostMapping("/uploadImg")
    public CommonResult uploadImg(MultipartFile file){
        String filePath=uploadService.uploadImg( file );
        Map<String,String> result = new HashMap<>(  );
        result.put( "filePath",filePath );
        return new CommonResult().success( result );
    }
}
