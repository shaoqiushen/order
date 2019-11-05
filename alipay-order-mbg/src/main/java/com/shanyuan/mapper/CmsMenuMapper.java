package com.shanyuan.mapper;

import com.shanyuan.model.CmsMenu;
import com.shanyuan.model.CmsMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsMenuMapper {
    int countByExample(CmsMenuExample example);

    int deleteByExample(CmsMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsMenu record);

    int insertSelective(CmsMenu record);

    List<CmsMenu> selectByExample(CmsMenuExample example);

    CmsMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsMenu record, @Param("example") CmsMenuExample example);

    int updateByExample(@Param("record") CmsMenu record, @Param("example") CmsMenuExample example);

    int updateByPrimaryKeySelective(CmsMenu record);

    int updateByPrimaryKey(CmsMenu record);
}