package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.BranchDao;
import com.demo.model.BranchVO;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDao branchDao;

	@Override
	public void save(BranchVO branchVO) {
		this.branchDao.save(branchVO);
	}

	@Override
	public List<BranchVO> getBranch() {
		return this.branchDao.getBranch();
	}

	@Override
	public List<BranchVO> getBranchById(int branchid) {
		return this.branchDao.getBranchById(branchid);
	}

}
