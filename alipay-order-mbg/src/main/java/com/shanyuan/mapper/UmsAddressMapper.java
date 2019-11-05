package com.shanyuan.mapper;

import com.shanyuan.model.UmsAddress;
import com.shanyuan.model.UmsAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAddressMapper {
    int countByExample(UmsAddressExample example);

    int deleteByExample(UmsAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsAddress record);

    int insertSelective(UmsAddress record);

    List<UmsAddress> selectByExample(UmsAddressExample example);

    UmsAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsAddress record, @Param("example") UmsAddressExample example);

    int updateByExample(@Param("record") UmsAddress record, @Param("example") UmsAddressExample example);

    int updateByPrimaryKeySelective(UmsAddress record);

    int updateByPrimaryKey(UmsAddress record);
}