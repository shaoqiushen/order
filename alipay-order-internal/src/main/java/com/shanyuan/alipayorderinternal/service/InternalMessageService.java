package com.shanyuan.alipayorderinternal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalMessageParams;
import com.shanyuan.model.MysMessage;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 11:47
 * <p>
 * desc
 **/
public interface InternalMessageService {
    int createMessage(InternalMessageParams params);
    PageInfo<MysMessage> listMessage(Integer pageNum,Integer pageSize);
}
