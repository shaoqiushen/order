package com.shanyuan.mapper;

import com.shanyuan.model.CmsDelivery;
import com.shanyuan.model.CmsDeliveryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsDeliveryMapper {
    int countByExample(CmsDeliveryExample example);

    int deleteByExample(CmsDeliveryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsDelivery record);

    int insertSelective(CmsDelivery record);

    List<CmsDelivery> selectByExample(CmsDeliveryExample example);

    CmsDelivery selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsDelivery record, @Param("example") CmsDeliveryExample example);

    int updateByExample(@Param("record") CmsDelivery record, @Param("example") CmsDeliveryExample example);

    int updateByPrimaryKeySelective(CmsDelivery record);

    int updateByPrimaryKey(CmsDelivery record);
}