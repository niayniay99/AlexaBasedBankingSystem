package com.demo.dao;

import java.util.List;

import com.demo.model.AreaVO;

public interface AreaDao {

	void save(AreaVO areaVO);

	List<AreaVO> getArea();

	List<AreaVO> getAreaById(int areaId);
}
