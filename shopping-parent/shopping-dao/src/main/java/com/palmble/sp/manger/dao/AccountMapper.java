package com.palmble.sp.manger.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.palmble.sp.manger.model.Account;

@Mapper
public interface AccountMapper{
    
    int insert(Account account);
    
    int insertFully(Account account);
    
    int deleteById(Integer id);
    
    int updateById(Account account);
    
    int updateByUserId(Account account);

    int updateFullyById(Account account);
    
    Account getById(Integer id);
    
    Account getByUserId(Integer id);
    
    //int startRow, int pageSize, object2map
    

    int count(Map<String, Object> params);

}