package com.shanyuan.alipayorderportal.dto;

import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemCategory;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 17:21
 * <p>
 * desc
 **/
@Data
public class PortalHomeResult {
    private List<PmsItemCategory> itemCategoryList;
    private List<PmsItem> itemList;
}
