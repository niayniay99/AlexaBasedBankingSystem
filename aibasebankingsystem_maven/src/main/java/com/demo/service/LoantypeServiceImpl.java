package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.LoantypeDao;
import com.demo.model.LoantypeVO;

@Service
@Transactional
public class LoantypeServiceImpl implements LoantypeService {

	@Autowired
	private LoantypeDao loantypeDao;
	
	@Override
	public void save(LoantypeVO loantypeVO) {
		this.loantypeDao.save(loantypeVO);
		
	}

	@Override
	public List<LoantypeVO> getLoantype() {

		return this.loantypeDao.getLoantype();
	}

	@Override
	public List<LoantypeVO> getLoantypeById(int id) {
		return this.loantypeDao.getLoantypeById(id);
	}
}
