package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AreaDao;
import com.demo.model.AreaVO;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;

	@Override
	public void save(AreaVO areaVO) {
		this.areaDao.save(areaVO);
	}

	@Override
	public List<AreaVO> getArea() {
		return this.areaDao.getArea();
	}

	@Override
	public List<AreaVO> getAreaById(int areaId) {
		return this.areaDao.getAreaById(areaId);
	}

}
