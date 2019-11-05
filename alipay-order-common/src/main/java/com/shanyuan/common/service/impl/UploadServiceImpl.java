package com.shanyuan.common.service.impl;


import com.aliyun.oss.OSSClient;
import com.shanyuan.common.exception.BussinessException;
import com.shanyuan.common.service.UploadService;
import lombok.extern.slf4j.Slf4j;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-23 10:23
 * <p>
 * desc
 **/
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Value("${aliyun.oss.policy.expire}")
    private int ALIYUN_OSS_EXPIRE;
    @Value("${aliyun.oss.maxSize}")
    private int ALIYUN_OSS_MAX_SIZE;
    @Value("${aliyun.oss.callback}")
    private String ALIYUN_OSS_CALLBACK;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.dir.prefix}")
    private String ALIYUN_OSS_DIR_PREFIX;
    @Value("${aliyun.oss.scaleRatio}")
    private double scaleRatio;
    @Value( "${aliyun.oss.accessKeyId}" )
    private String accessKeyId;
    @Value( "${aliyun.oss.accessKeySecret}" )
    private String accessKeySecret;
    @Value( "${aliyun.oss.imgPath}" )
    private String imgPath;

    @Override
    public String uploadImg(MultipartFile file) {
        OSSClient ossClient = null;
        String path = null;
        try{
            if(file.isEmpty()){
                throw new BussinessException("上传图片失败,图片不允许为空");
            }
            String[] IMAGE_TYPE="png,jpg,jpeg".split( "," );//允许上传的文件类型
            boolean flag = false;
            for (String type : IMAGE_TYPE) {
                if (StringUtils.endsWithIgnoreCase( file.getOriginalFilename(), type )) {
                    flag=true;
                    break;
                }
            }
            if(!flag){
                throw new BussinessException( "上传图片失败,图片只允许上传png,jpg,jpeg格式" );
            }

            //连接阿里oss服务
            ossClient=new OSSClient(endpoint,accessKeyId, accessKeySecret );

            /*存储目录*/
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyyMMdd" );
            String dir = ALIYUN_OSS_DIR_PREFIX + simpleDateFormat.format( new Date(  ) );
            // 获得文件类型
            String fileType=file.getContentType();
            // 获得文件后缀名称
            String imageName=fileType.substring( fileType.indexOf( "/" ) + 1 );
            String uuid=UUID.randomUUID().toString().replaceAll( "-", "" );
            path = dir + "/" + uuid + "." + imageName;
            String serverPath=System.getProperty( "user.dir" );//服务部署的目录
            // 如果目录不存在则创建目录
            File uploadFile=new File( serverPath+"/"+path );
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }

            // 文件大小
            long maxSize = ALIYUN_OSS_MAX_SIZE * 1024 * 1024;
            // 进行压缩(大于规定大小)
            if (file.getSize() > maxSize) {
                file.transferTo( uploadFile );
                // 压缩图片
                Thumbnails.of( uploadFile ).scale( scaleRatio ).toFile( path );
            } else {
                file.transferTo( uploadFile );
            }
            ossClient.putObject( bucketName, path, uploadFile );//上传到oss服务器
            //删除临时图片
            uploadFile.delete();
        }catch ( Exception e ){
            log.error( "uploadImg error",e );
            throw new BussinessException( "上传图片失败" );
        }finally {
            if(ossClient != null){
                ossClient.shutdown();
            }
        }
        return  imgPath + path;
    }
}
