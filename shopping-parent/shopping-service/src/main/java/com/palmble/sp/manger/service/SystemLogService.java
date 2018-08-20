package com.palmble.sp.manger.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.palmble.sp.manger.model.SystemLog;
import com.palmble.sp.manger.utils.ResultInfo;

public interface SystemLogService {

	int save(SystemLog log);

	PageInfo<SystemLog> getList(Map<String, Object> map);

	ResultInfo deleteOne(Long id);
	
}
