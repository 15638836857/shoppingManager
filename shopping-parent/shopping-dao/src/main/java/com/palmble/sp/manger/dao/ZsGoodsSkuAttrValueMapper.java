package com.palmble.sp.manger.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.palmble.sp.manger.model.ZsGoodsSkuAttrValue;
@Mapper
public interface ZsGoodsSkuAttrValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZsGoodsSkuAttrValue record);

    int insertSelective(ZsGoodsSkuAttrValue record);

    ZsGoodsSkuAttrValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZsGoodsSkuAttrValue record);

    int updateByPrimaryKey(ZsGoodsSkuAttrValue record);

	void deleteBySkuId(Integer id);

	List<ZsGoodsSkuAttrValue> selectSKUValuesByskuId(Integer id);
}