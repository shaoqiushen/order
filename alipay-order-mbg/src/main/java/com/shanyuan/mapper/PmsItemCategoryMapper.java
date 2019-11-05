package com.shanyuan.mapper;

import com.shanyuan.model.PmsItemCategory;
import com.shanyuan.model.PmsItemCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsItemCategoryMapper {
    int countByExample(PmsItemCategoryExample example);

    int deleteByExample(PmsItemCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsItemCategory record);

    int insertSelective(PmsItemCategory record);

    List<PmsItemCategory> selectByExample(PmsItemCategoryExample example);

    PmsItemCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsItemCategory record, @Param("example") PmsItemCategoryExample example);

    int updateByExample(@Param("record") PmsItemCategory record, @Param("example") PmsItemCategoryExample example);

    int updateByPrimaryKeySelective(PmsItemCategory record);

    int updateByPrimaryKey(PmsItemCategory record);
}