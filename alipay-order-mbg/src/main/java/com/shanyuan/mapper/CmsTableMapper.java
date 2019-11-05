package com.shanyuan.mapper;

import com.shanyuan.model.CmsTable;
import com.shanyuan.model.CmsTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsTableMapper {
    int countByExample(CmsTableExample example);

    int deleteByExample(CmsTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsTable record);

    int insertSelective(CmsTable record);

    List<CmsTable> selectByExample(CmsTableExample example);

    CmsTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsTable record, @Param("example") CmsTableExample example);

    int updateByExample(@Param("record") CmsTable record, @Param("example") CmsTableExample example);

    int updateByPrimaryKeySelective(CmsTable record);

    int updateByPrimaryKey(CmsTable record);
}