package com.shanyuan.mapper;

import com.shanyuan.model.OmsPrepay;
import com.shanyuan.model.OmsPrepayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsPrepayMapper {
    int countByExample(OmsPrepayExample example);

    int deleteByExample(OmsPrepayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OmsPrepay record);

    int insertSelective(OmsPrepay record);

    List<OmsPrepay> selectByExample(OmsPrepayExample example);

    OmsPrepay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OmsPrepay record, @Param("example") OmsPrepayExample example);

    int updateByExample(@Param("record") OmsPrepay record, @Param("example") OmsPrepayExample example);

    int updateByPrimaryKeySelective(OmsPrepay record);

    int updateByPrimaryKey(OmsPrepay record);
}