package com.demo.service;

import java.util.List;

import com.demo.model.LoantypeVO;

public interface LoantypeService {

	void save(LoantypeVO loantypeVO);

	List<LoantypeVO> getLoantype();

	List<LoantypeVO> getLoantypeById(int id);
	
}
