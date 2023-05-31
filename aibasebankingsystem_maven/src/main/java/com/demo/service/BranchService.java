package com.demo.service;

import java.util.List;

import com.demo.model.BranchVO;

public interface BranchService {

	void save(BranchVO branchVO);
	
	List<BranchVO> getBranch();

	List<BranchVO> getBranchById(int branchid);

	

}
