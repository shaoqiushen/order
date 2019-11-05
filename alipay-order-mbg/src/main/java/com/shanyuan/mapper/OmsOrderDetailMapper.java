package com.shanyuan.mapper;

import com.shanyuan.model.OmsOrderDetail;
import com.shanyuan.model.OmsOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderDetailMapper {
    int countByExample(OmsOrderDetailExample example);

    int deleteByExample(OmsOrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OmsOrderDetail record);

    int insertSelective(OmsOrderDetail record);

    List<OmsOrderDetail> selectByExample(OmsOrderDetailExample example);

    OmsOrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OmsOrderDetail record, @Param("example") OmsOrderDetailExample example);

    int updateByExample(@Param("record") OmsOrderDetail record, @Param("example") OmsOrderDetailExample example);

    int updateByPrimaryKeySelective(OmsOrderDetail record);

    int updateByPrimaryKey(OmsOrderDetail record);
}