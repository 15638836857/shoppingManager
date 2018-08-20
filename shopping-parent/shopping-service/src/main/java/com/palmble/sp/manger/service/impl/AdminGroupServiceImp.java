package com.palmble.sp.manger.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmble.sp.manger.dao.AdminGroupsMapper;
import com.palmble.sp.manger.model.AdminGroups;
import com.palmble.sp.manger.service.AdminGroupsService;

@Service
public class AdminGroupServiceImp implements AdminGroupsService{

	@Autowired
	private AdminGroupsMapper groupDao;
	@Override
	public int insert(AdminGroups adminGroups) {
		return groupDao.insert(adminGroups);
	}

	@Override
	public int insertFully(AdminGroups adminGroups) {
		return groupDao.insertFully(adminGroups);
	}

	@Override
	public int deleteById(Integer id) {
		return groupDao.deleteById(id);
	}

	@Override
	public int updateById(AdminGroups adminGroups) {
		return groupDao.updateById(adminGroups);
	}

	@Override
	public int updateFullyById(AdminGroups adminGroups) {
		return groupDao.updateFullyById(adminGroups);
	}

	@Override
	public AdminGroups getById(Integer id) {
		return groupDao.getById(id);
	}

	@Override
	public List<AdminGroups> find(Map<String, Object> params) {
		return groupDao.find(params);
	}

	@Override
	public int count(Map<String, Object> params) {
		return groupDao.count(params);
	}

}
