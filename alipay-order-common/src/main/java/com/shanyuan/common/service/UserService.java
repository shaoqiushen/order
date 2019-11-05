package com.shanyuan.common.service;

import com.shanyuan.model.UmsAddress;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:52
 * <p>
 * desc
 **/
public interface UserService {

    List<UmsAddress> listUserAddress(Integer pageNum, Integer pageSize, String userId);
}
