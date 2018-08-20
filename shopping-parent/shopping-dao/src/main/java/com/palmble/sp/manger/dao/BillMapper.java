package com.palmble.sp.manger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.palmble.sp.manger.model.Bill;

@Mapper
public interface BillMapper{
    
    int insert(Bill bill);
    
    int insertFully(Bill bill);
    
    int deleteById(Integer id);
    
    int updateById(Bill bill);

    int updateFullyById(Bill bill);
    
    Bill getById(Integer id);
    
    //int startRow, int pageSize, object2map
    
    List<Bill> find(Map<String, Object> params);

    int count(Map<String, Object> params);

}