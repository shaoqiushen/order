package com.shanyuan.mapper;

import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsItemMapper {
    int countByExample(PmsItemExample example);

    int deleteByExample(PmsItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsItem record);

    int insertSelective(PmsItem record);

    List<PmsItem> selectByExample(PmsItemExample example);

    PmsItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsItem record, @Param("example") PmsItemExample example);

    int updateByExample(@Param("record") PmsItem record, @Param("example") PmsItemExample example);

    int updateByPrimaryKeySelective(PmsItem record);

    int updateByPrimaryKey(PmsItem record);
}