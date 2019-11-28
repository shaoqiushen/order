package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.*;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.CmsReceiptCode;
import com.shanyuan.model.OmsOrder;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 10:46
 * <p>
 * desc
 **/
public interface OmsReceiptCodeService {
    PageInfo<OmsReceiptCodeResult> listReceiptCode(Integer pageNum, Integer pageSize, OmsReceiptQueryParams params);
    PageInfo<OmsOrder> listOrderByDeskNo(Long brandId, Integer pageNum, Integer pageSize,String deskNo);

    CommonResult createReceiptCode(CmsReceiptCodeParams params);
    CommonResult updateReceiptCode(Integer id, CmsReceiptCodeParams params);
    PageInfo<CmsReceiptCodeResult> listReceiptCodeByStoreId(Integer storeId, Integer pageNum, Integer pageSize);
    int deleteReceiptCode(Integer id);
    CmsReceiptCode getReceiptCodeInfo(String deskNo,Integer storeId);
    PageInfo<CmsReceiptCode> listDeskNo(Long brandId,Integer storeId,Integer pageNum,Integer pageSize);

    int countCode(Long brandId,Integer storeId);

    PageInfo<CmsReceiptCodeRes> listReceiptCodeByParams(BrandStoreParams params,Integer pageNum,Integer pageSize);
}
