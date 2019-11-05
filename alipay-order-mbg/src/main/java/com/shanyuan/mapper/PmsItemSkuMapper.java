package com.shanyuan.mapper;

import com.shanyuan.model.PmsItemSku;
import com.shanyuan.model.PmsItemSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsItemSkuMapper {
    int countByExample(PmsItemSkuExample example);

    int deleteByExample(PmsItemSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsItemSku record);

    int insertSelective(PmsItemSku record);

    List<PmsItemSku> selectByExample(PmsItemSkuExample example);

    PmsItemSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsItemSku record, @Param("example") PmsItemSkuExample example);

    int updateByExample(@Param("record") PmsItemSku record, @Param("example") PmsItemSkuExample example);

    int updateByPrimaryKeySelective(PmsItemSku record);

    int updateByPrimaryKey(PmsItemSku record);
}