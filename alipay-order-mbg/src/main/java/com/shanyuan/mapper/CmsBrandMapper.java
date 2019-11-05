package com.shanyuan.mapper;

import com.shanyuan.model.CmsBrand;
import com.shanyuan.model.CmsBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsBrandMapper {
    int countByExample(CmsBrandExample example);

    int deleteByExample(CmsBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CmsBrand record);

    int insertSelective(CmsBrand record);

    List<CmsBrand> selectByExample(CmsBrandExample example);

    CmsBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmsBrand record, @Param("example") CmsBrandExample example);

    int updateByExample(@Param("record") CmsBrand record, @Param("example") CmsBrandExample example);

    int updateByPrimaryKeySelective(CmsBrand record);

    int updateByPrimaryKey(CmsBrand record);
}