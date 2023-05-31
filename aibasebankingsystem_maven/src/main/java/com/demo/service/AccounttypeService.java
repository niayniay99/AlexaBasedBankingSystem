package com.demo.service;

import java.util.List;

import com.demo.model.AccounttypeVO;

public interface AccounttypeService {

	void save(AccounttypeVO accounttypeVO);

	List<AccounttypeVO> getAccounttype();

	List<AccounttypeVO> getAccounttypeById(int id);
	
}
