package com.palmble.sp.manger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.palmble.sp.manger.model.OrderInfo;
@Mapper
public interface OrderInfoMapper {

	// int insert(OrderInfo orderInfo);

	// int insertFully(OrderInfo orderInfo);

	int deleteById(Integer id);

	int updateById(OrderInfo orderInfo);

	// int updateFullyById(OrderInfo orderInfo);

	OrderInfo getById(Integer id);

	OrderInfo getSimpleResultById(Integer id);

	// int startRow, int pageSize, object2map

	List<OrderInfo> find(Map<String, Object> params);

	int count(Map<String, Object> params);

	List<OrderInfo> findSimpleResult(Map<String, Object> params);

	List<OrderInfo> fuzzyQuery(Map<String, Object> params);

	List<Map<String, Object>> findSimpleResultToMap(Map<String, Object> params);

	List<OrderInfo> fuzzyQueryAllResult(Map<String, Object> params);

}