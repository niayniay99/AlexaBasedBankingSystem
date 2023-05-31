package com.demo.dao;

import java.util.List;

import com.demo.model.BranchVO;

public interface BranchDao {

	void save(BranchVO branchVO);

	List<BranchVO> getBranch();

	List<BranchVO> getBranchById(int branchid);

}
