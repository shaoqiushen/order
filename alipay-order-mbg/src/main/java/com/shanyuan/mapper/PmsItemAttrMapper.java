package com.shanyuan.mapper;

import com.shanyuan.model.PmsItemAttr;
import com.shanyuan.model.PmsItemAttrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsItemAttrMapper {
    int countByExample(PmsItemAttrExample example);

    int deleteByExample(PmsItemAttrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsItemAttr record);

    int insertSelective(PmsItemAttr record);

    List<PmsItemAttr> selectByExample(PmsItemAttrExample example);

    PmsItemAttr selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsItemAttr record, @Param("example") PmsItemAttrExample example);

    int updateByExample(@Param("record") PmsItemAttr record, @Param("example") PmsItemAttrExample example);

    int updateByPrimaryKeySelective(PmsItemAttr record);

    int updateByPrimaryKey(PmsItemAttr record);
}