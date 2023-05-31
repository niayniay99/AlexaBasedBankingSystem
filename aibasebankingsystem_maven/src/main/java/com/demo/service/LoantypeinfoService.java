package com.demo.service;

import java.util.List;

import com.demo.model.LoantypeinfoVO;

public interface LoantypeinfoService {

	void save(LoantypeinfoVO loantypeinfoVO);
	  
	List<LoantypeinfoVO> getLoantypeinfo();

	List<LoantypeinfoVO> getLoantypeinfoById(int id);

	
}
