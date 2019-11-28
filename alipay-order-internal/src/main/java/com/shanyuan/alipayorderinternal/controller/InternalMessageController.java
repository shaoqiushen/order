package com.shanyuan.alipayorderinternal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalMessageParams;
import com.shanyuan.alipayorderinternal.service.InternalMessageService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.MysMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 11:47
 * <p>
 * desc
 **/
@Api(value="InternalMessageController",description="消息管理")
@RestController
@RequestMapping("/internal/message")
public class InternalMessageController {

    @Autowired
    InternalMessageService internalMessageService;


    @ApiOperation( "创建消息" )
    @PostMapping("/createMessage")
    public CommonResult createMessage(@Validated @RequestBody InternalMessageParams params, BindingResult bindingResult){
        int count=internalMessageService.createMessage( params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "消息列表" )
    @PostMapping("/listMessage")
    public CommonResult listMessage(@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <MysMessage> pageInfo=internalMessageService.listMessage( pageNum, pageSize );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
