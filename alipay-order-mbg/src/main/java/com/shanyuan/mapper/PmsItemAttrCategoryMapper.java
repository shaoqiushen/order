package com.shanyuan.mapper;

import com.shanyuan.model.PmsItemAttrCategory;
import com.shanyuan.model.PmsItemAttrCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsItemAttrCategoryMapper {
    int countByExample(PmsItemAttrCategoryExample example);

    int deleteByExample(PmsItemAttrCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsItemAttrCategory record);

    int insertSelective(PmsItemAttrCategory record);

    List<PmsItemAttrCategory> selectByExample(PmsItemAttrCategoryExample example);

    PmsItemAttrCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsItemAttrCategory record, @Param("example") PmsItemAttrCategoryExample example);

    int updateByExample(@Param("record") PmsItemAttrCategory record, @Param("example") PmsItemAttrCategoryExample example);

    int updateByPrimaryKeySelective(PmsItemAttrCategory record);

    int updateByPrimaryKey(PmsItemAttrCategory record);
}