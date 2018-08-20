package com.palmble.sp.manger.dao;

import org.apache.ibatis.annotations.Mapper;

import com.palmble.sp.manger.model.ZsGoodsSkuAttr;
@Mapper
public interface ZsGoodsSkuAttrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZsGoodsSkuAttr record);

    int insertSelective(ZsGoodsSkuAttr record);

    ZsGoodsSkuAttr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZsGoodsSkuAttr record);

    int updateByPrimaryKey(ZsGoodsSkuAttr record);
}