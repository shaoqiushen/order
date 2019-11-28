package com.shanyuan.alipayorderinternal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalMessageParams;
import com.shanyuan.alipayorderinternal.service.InternalMessageService;
import com.shanyuan.mapper.MysMessageMapper;
import com.shanyuan.model.MysMessage;
import com.shanyuan.model.MysMessageExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 11:47
 * <p>
 * desc
 **/
@Service
public class InternalMessageServiceImpl implements InternalMessageService {

    @Autowired
    MysMessageMapper mysMessageMapper;


    @Override
    public int createMessage(InternalMessageParams params) {
        MysMessage mysMessage = new MysMessage();
        BeanUtils.copyProperties( params,mysMessage );
        return mysMessageMapper.insertSelective( mysMessage );
    }

    @Override
    public PageInfo<MysMessage> listMessage(Integer pageNum, Integer pageSize) {
        MysMessageExample example = new MysMessageExample();
        example.setOrderByClause( "id desc" );
        PageHelper.startPage( pageNum,pageSize );
        List <MysMessage> mysMessages=mysMessageMapper.selectByExample( example );
        PageInfo<MysMessage> pageInfo = new PageInfo <>( mysMessages );
        return pageInfo;
    }
}
