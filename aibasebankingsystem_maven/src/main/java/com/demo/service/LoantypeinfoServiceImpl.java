package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.LoantypeinfoDao;
import com.demo.model.LoantypeinfoVO;

@Service
@Transactional
public class LoantypeinfoServiceImpl implements LoantypeinfoService {
	
	@Autowired
	private LoantypeinfoDao loantypeinfoDao;
	
	@Override
	
	public void save(LoantypeinfoVO loantypeinfoVO) {
			this.loantypeinfoDao.save(loantypeinfoVO);
	}
	
	@Override
	public List<LoantypeinfoVO> getLoantypeinfo() {
		return this.loantypeinfoDao.getLoantypeinfo();
	}

	@Override
	public List<LoantypeinfoVO> getLoantypeinfoById(int id) {
		return this.loantypeinfoDao.getLoantypeinfoById(id);
	}
	
}
