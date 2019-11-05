package com.shanyuan.mapper;

import com.shanyuan.model.CmsPackage;
import com.shanyuan.model.CmsPackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsPackageMapper {
    int countByExample(CmsPackageExample example);

    int deleteByExample(CmsPackageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsPackage record);

    int insertSelective(CmsPackage record);

    List<CmsPackage> selectByExample(CmsPackageExample example);

    CmsPackage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsPackage record, @Param("example") CmsPackageExample example);

    int updateByExample(@Param("record") CmsPackage record, @Param("example") CmsPackageExample example);

    int updateByPrimaryKeySelective(CmsPackage record);

    int updateByPrimaryKey(CmsPackage record);
}