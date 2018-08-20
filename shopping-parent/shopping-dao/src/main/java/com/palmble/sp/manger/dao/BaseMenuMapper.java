package com.palmble.sp.manger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.palmble.sp.manger.model.BaseMenu;

@Mapper
public interface BaseMenuMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(BaseMenu record);

    int insertSelective(BaseMenu record);

    BaseMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseMenu record);

    int updateByPrimaryKey(BaseMenu record);
    List<BaseMenu> byAllMenuList(Map<String, String> map);
    
    List<BaseMenu> getAll(@Param("page")Integer page,@Param("rows")Integer rows);
    
    BaseMenu selectBySelective(BaseMenu record);
}