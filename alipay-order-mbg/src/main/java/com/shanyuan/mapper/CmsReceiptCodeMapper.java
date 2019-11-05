package com.shanyuan.mapper;

import com.shanyuan.model.CmsReceiptCode;
import com.shanyuan.model.CmsReceiptCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsReceiptCodeMapper {
    int countByExample(CmsReceiptCodeExample example);

    int deleteByExample(CmsReceiptCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsReceiptCode record);

    int insertSelective(CmsReceiptCode record);

    List<CmsReceiptCode> selectByExample(CmsReceiptCodeExample example);

    CmsReceiptCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsReceiptCode record, @Param("example") CmsReceiptCodeExample example);

    int updateByExample(@Param("record") CmsReceiptCode record, @Param("example") CmsReceiptCodeExample example);

    int updateByPrimaryKeySelective(CmsReceiptCode record);

    int updateByPrimaryKey(CmsReceiptCode record);
}