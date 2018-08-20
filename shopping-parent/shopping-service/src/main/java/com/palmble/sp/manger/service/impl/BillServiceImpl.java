package com.palmble.sp.manger.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmble.sp.manger.dao.BillMapper;
import com.palmble.sp.manger.model.Bill;
import com.palmble.sp.manger.service.BillService;
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillMapper billDao;
	@Override
	public int insert(Bill bill) {
		return billDao.insert(bill);
	}

	@Override
	public int insertFully(Bill bill) {
		return billDao.insertFully(bill);
	}

	@Override
	public int deleteById(Integer id) {
		return billDao.deleteById(id);
	}

	@Override
	public int updateById(Bill bill) {
		return billDao.updateById(bill);
	}

	@Override
	public int updateFullyById(Bill bill) {
		return billDao.updateFullyById(bill);
	}

	@Override
	public Bill getById(Integer id) {
		return billDao.getById(id);
	}

	@Override
	public List<Bill> find(Map<String, Object> params) {
		return billDao.find(params);
	}

	@Override
	public int count(Map<String, Object> params) {
		return billDao.count(params);
	}

}
