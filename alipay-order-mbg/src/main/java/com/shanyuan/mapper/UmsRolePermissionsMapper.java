package com.shanyuan.mapper;

import com.shanyuan.model.UmsRolePermissions;
import com.shanyuan.model.UmsRolePermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRolePermissionsMapper {
    int countByExample(UmsRolePermissionsExample example);

    int deleteByExample(UmsRolePermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsRolePermissions record);

    int insertSelective(UmsRolePermissions record);

    List<UmsRolePermissions> selectByExample(UmsRolePermissionsExample example);

    UmsRolePermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsRolePermissions record, @Param("example") UmsRolePermissionsExample example);

    int updateByExample(@Param("record") UmsRolePermissions record, @Param("example") UmsRolePermissionsExample example);

    int updateByPrimaryKeySelective(UmsRolePermissions record);

    int updateByPrimaryKey(UmsRolePermissions record);
}