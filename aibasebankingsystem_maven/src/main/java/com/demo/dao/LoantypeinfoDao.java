package com.demo.dao;

import java.util.List;

import com.demo.model.LoantypeinfoVO;

public interface LoantypeinfoDao {

	void save(LoantypeinfoVO loantypeinfoVO);

	List<LoantypeinfoVO> getLoantypeinfo();

	List<LoantypeinfoVO> getLoantypeinfoById(int id);

	
}
