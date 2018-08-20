package com.palmble.sp.manger.service;

import java.util.List;

import com.palmble.sp.manger.model.UserPermission;

public interface UserPermissionService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    List<UserPermission> selectByGroupOrUserId(Integer id);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
    
    List<Integer> selectPrivilegeUrlByGroupOrUserId(Integer userid);
    //查询用户是否拥有权限
    Boolean privilegeStatus(Integer userid,String path);
}
