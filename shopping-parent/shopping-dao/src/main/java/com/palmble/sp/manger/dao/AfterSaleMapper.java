package com.palmble.sp.manger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.palmble.sp.manger.model.AfterSale;

@Mapper
public interface AfterSaleMapper{
    
    int insert(AfterSale afterSale);
    
    int insertFully(AfterSale afterSale);
    
    int deleteById(Integer id);
    
    int updateById(AfterSale afterSale);

    int updateFullyById(AfterSale afterSale);
    
    AfterSale getById(Integer id);
    
    //int startRow, int pageSize, object2map
    
    List<AfterSale> find(Map<String, Object> params);

    int count(Map<String, Object> params);

}