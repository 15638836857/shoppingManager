package com.palmble.sp.manger.service;

import java.util.List;
import java.util.Map;

import com.palmble.sp.manger.model.Bill;

public interface BillService {
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
