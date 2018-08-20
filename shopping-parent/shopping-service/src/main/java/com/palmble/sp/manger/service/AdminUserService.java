package com.palmble.sp.manger.service;

import java.util.List;
import java.util.Map;

import com.palmble.sp.manger.model.AdminUser;

public interface AdminUserService {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
    
    List<AdminUser> selectBySelective(Map<String,Object> map);
    
    AdminUser selectOne(String key,Object value);
    
}
