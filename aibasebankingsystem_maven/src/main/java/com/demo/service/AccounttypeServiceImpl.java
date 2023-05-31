package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AccounttypeDao;
import com.demo.model.AccounttypeVO;

@Service
@Transactional
public class AccounttypeServiceImpl implements AccounttypeService {
	
	@Autowired
	private AccounttypeDao accounttypeDao;

	@Override
	public void save(AccounttypeVO accounttypeVO) {
		 this.accounttypeDao.save(accounttypeVO);
		
	}

	@Override
	public List<AccounttypeVO> getAccounttype() {

		return this.accounttypeDao.getAccounttype();
	}

	@Override
	public List<AccounttypeVO> getAccounttypeById(int id) {
		return this.accounttypeDao.getAccounttypeById(id);
	}

}
