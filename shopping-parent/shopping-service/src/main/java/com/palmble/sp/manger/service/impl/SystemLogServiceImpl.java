package com.palmble.sp.manger.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.palmble.sp.manger.dao.SystemLogMapper;
import com.palmble.sp.manger.model.SystemLog;
import com.palmble.sp.manger.service.SystemLogService;
import com.palmble.sp.manger.utils.ResultInfo;

@Service
public class SystemLogServiceImpl implements SystemLogService{
	
	@Autowired
	private SystemLogMapper logMapper;

	@Override
	public int save(SystemLog log) {
		return logMapper.insert(log);
	}

	@Override
	public PageInfo<SystemLog> getList(Map<String, Object> map) {
		PageHelper.startPage(Integer.parseInt(map.get("page").toString()), Integer.parseInt(map.get("rows").toString()));
		List<SystemLog> logList = logMapper.getSystemLogList(map);
		PageInfo<SystemLog> pageSource=new PageInfo<>(logList);
		return pageSource;
	}

	public ResultInfo deleteOne(Long id) {
		int num=0;
		if(id!=null) {
			num = logMapper.deleteByPrimaryKey(id);
			if(num>0) {
				return new ResultInfo(1, "操作成功");
			}else {
				return new ResultInfo(-1, "操作失败");
			}
		}else {
			return new ResultInfo(-1, "操作失败");
		}
		
	}

}
