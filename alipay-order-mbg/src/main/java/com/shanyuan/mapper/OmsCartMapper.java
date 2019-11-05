package com.shanyuan.mapper;

import com.shanyuan.model.OmsCart;
import com.shanyuan.model.OmsCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsCartMapper {
    int countByExample(OmsCartExample example);

    int deleteByExample(OmsCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OmsCart record);

    int insertSelective(OmsCart record);

    List<OmsCart> selectByExample(OmsCartExample example);

    OmsCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OmsCart record, @Param("example") OmsCartExample example);

    int updateByExample(@Param("record") OmsCart record, @Param("example") OmsCartExample example);

    int updateByPrimaryKeySelective(OmsCart record);

    int updateByPrimaryKey(OmsCart record);
}