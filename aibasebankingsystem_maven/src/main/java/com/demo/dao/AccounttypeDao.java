package com.demo.dao;

import java.util.List;

import com.demo.model.AccounttypeVO;

public interface AccounttypeDao {

	void save(AccounttypeVO accounttypeVO);

	List<AccounttypeVO> getAccounttype();

	List<AccounttypeVO> getAccounttypeById(int id);

}
