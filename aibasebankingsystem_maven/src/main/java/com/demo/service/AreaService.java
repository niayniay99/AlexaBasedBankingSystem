package com.demo.service;

import java.util.List;

import com.demo.model.AreaVO;

public interface AreaService {

	void save(AreaVO areaVO);

	List<AreaVO> getArea();

	List<AreaVO> getAreaById(int areaId);

}
