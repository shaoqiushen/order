package com.shanyuan.mapper;

import com.shanyuan.model.PmsItemAttrValue;
import com.shanyuan.model.PmsItemAttrValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsItemAttrValueMapper {
    int countByExample(PmsItemAttrValueExample example);

    int deleteByExample(PmsItemAttrValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PmsItemAttrValue record);

    int insertSelective(PmsItemAttrValue record);

    List<PmsItemAttrValue> selectByExample(PmsItemAttrValueExample example);

    PmsItemAttrValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PmsItemAttrValue record, @Param("example") PmsItemAttrValueExample example);

    int updateByExample(@Param("record") PmsItemAttrValue record, @Param("example") PmsItemAttrValueExample example);

    int updateByPrimaryKeySelective(PmsItemAttrValue record);

    int updateByPrimaryKey(PmsItemAttrValue record);
}