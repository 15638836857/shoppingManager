package com.palmble.sp.manger.service;

import java.util.List;
import java.util.Map;

import com.palmble.sp.manger.model.AdminGroups;

public interface AdminGroupsService {
	 int insert(AdminGroups adminGroups);
	    
	    int insertFully(AdminGroups adminGroups);
	    
	    int deleteById(Integer id);
	    
	    int updateById(AdminGroups adminGroups);

	    int updateFullyById(AdminGroups adminGroups);
	    
	    AdminGroups getById(Integer id);
	    
	    //int startRow, int pageSize, object2map
	    
	    List<AdminGroups> find(Map<String, Object> params);

	    int count(Map<String, Object> params);
}
