package com.palmble.sp.manger.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmble.sp.manger.dao.UserPermissionMapper;
import com.palmble.sp.manger.model.UserPermission;
import com.palmble.sp.manger.service.UserPermissionService;

@Service(value="userPermissionServiceImpl")
public class UserPermissionServiceImpl implements UserPermissionService {
	@Autowired
	private UserPermissionMapper userPermissionMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userPermissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserPermission record) {
		return userPermissionMapper.insert(record);
	}

	@Override
	public int insertSelective(UserPermission record) {
		return userPermissionMapper.insertSelective(record);
	}

	@Override
	public List<UserPermission> selectByGroupOrUserId(Integer id) {
		return userPermissionMapper.selectByGroupOrUserId(id);
	}

	@Override
	public int updateByPrimaryKeySelective(UserPermission record) {
		return userPermissionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserPermission record) {
		return userPermissionMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Integer> selectPrivilegeUrlByGroupOrUserId(Integer userid) {
		return userPermissionMapper.selectPrivilegeUrlByGroupOrUserId(userid);
	}

	@Override
	public Boolean privilegeStatus(Integer groupId, String path) {
		if(path.endsWith(".html")&&path.startsWith("/")) {
			path=path.substring(1);
		}
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("groupId", groupId);
		param.put("path", path);
		Map<String,Object> map=userPermissionMapper.getByUserIdAndUrl(param);
		if(map==null) {
			return false;
		}
		return !map.isEmpty();
	}

}
