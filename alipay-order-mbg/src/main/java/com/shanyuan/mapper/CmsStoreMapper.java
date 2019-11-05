package com.shanyuan.mapper;

import com.shanyuan.model.CmsStore;
import com.shanyuan.model.CmsStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsStoreMapper {
    int countByExample(CmsStoreExample example);

    int deleteByExample(CmsStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsStore record);

    int insertSelective(CmsStore record);

    List<CmsStore> selectByExample(CmsStoreExample example);

    CmsStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsStore record, @Param("example") CmsStoreExample example);

    int updateByExample(@Param("record") CmsStore record, @Param("example") CmsStoreExample example);

    int updateByPrimaryKeySelective(CmsStore record);

    int updateByPrimaryKey(CmsStore record);
}