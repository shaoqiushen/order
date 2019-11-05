package com.shanyuan.mapper;

import com.shanyuan.model.CmsCarousel;
import com.shanyuan.model.CmsCarouselExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmsCarouselMapper {
    int countByExample(CmsCarouselExample example);

    int deleteByExample(CmsCarouselExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsCarousel record);

    int insertSelective(CmsCarousel record);

    List<CmsCarousel> selectByExample(CmsCarouselExample example);

    CmsCarousel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsCarousel record, @Param("example") CmsCarouselExample example);

    int updateByExample(@Param("record") CmsCarousel record, @Param("example") CmsCarouselExample example);

    int updateByPrimaryKeySelective(CmsCarousel record);

    int updateByPrimaryKey(CmsCarousel record);
}