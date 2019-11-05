package com.shanyuan.mapper;

import com.shanyuan.model.PmsItemSale;
import com.shanyuan.model.PmsItemSaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsItemSaleMapper {
    int countByExample(PmsItemSaleExample example);

    int deleteByExample(PmsItemSaleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsItemSale record);

    int insertSelective(PmsItemSale record);

    List<PmsItemSale> selectByExample(PmsItemSaleExample example);

    PmsItemSale selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsItemSale record, @Param("example") PmsItemSaleExample example);

    int updateByExample(@Param("record") PmsItemSale record, @Param("example") PmsItemSaleExample example);

    int updateByPrimaryKeySelective(PmsItemSale record);

    int updateByPrimaryKey(PmsItemSale record);
}