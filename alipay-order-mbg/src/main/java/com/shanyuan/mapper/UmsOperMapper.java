package com.shanyuan.mapper;

import com.shanyuan.model.UmsOper;
import com.shanyuan.model.UmsOperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsOperMapper {
    int countByExample(UmsOperExample example);

    int deleteByExample(UmsOperExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsOper record);

    int insertSelective(UmsOper record);

    List<UmsOper> selectByExample(UmsOperExample example);

    UmsOper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsOper record, @Param("example") UmsOperExample example);

    int updateByExample(@Param("record") UmsOper record, @Param("example") UmsOperExample example);

    int updateByPrimaryKeySelective(UmsOper record);

    int updateByPrimaryKey(UmsOper record);
}