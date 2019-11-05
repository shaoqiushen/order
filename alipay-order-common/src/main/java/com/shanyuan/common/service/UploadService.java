package com.shanyuan.common.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-23 10:23
 * <p>
 * desc
 **/
public interface UploadService {
    String uploadImg(MultipartFile file);
}
