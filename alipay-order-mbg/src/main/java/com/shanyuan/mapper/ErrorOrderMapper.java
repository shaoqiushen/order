package com.shanyuan.mapper;

import com.shanyuan.model.ErrorOrder;
import com.shanyuan.model.ErrorOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrorOrderMapper {
    int countByExample(ErrorOrderExample example);

    int deleteByExample(ErrorOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrorOrder record);

    int insertSelective(ErrorOrder record);

    List<ErrorOrder> selectByExample(ErrorOrderExample example);

    ErrorOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ErrorOrder record, @Param("example") ErrorOrderExample example);

    int updateByExample(@Param("record") ErrorOrder record, @Param("example") ErrorOrderExample example);

    int updateByPrimaryKeySelective(ErrorOrder record);

    int updateByPrimaryKey(ErrorOrder record);
}