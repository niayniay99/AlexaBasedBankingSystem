package com.demo.dao;

import java.util.List;

import com.demo.model.LoantypeVO;

public interface LoantypeDao {

	void save(LoantypeVO loantypeVO);

	List<LoantypeVO> getLoantype();

	List<LoantypeVO> getLoantypeById(int id);

	

}
