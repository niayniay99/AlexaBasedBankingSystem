package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.AccounttypeVO;
import com.demo.model.AreaVO;

@Repository
public class AccounttypeDaoImpl implements AccounttypeDao {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void save(AccounttypeVO accounttypeVO) {
		try {
			
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(accounttypeVO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AccounttypeVO> getAccounttype() {
		List<AccounttypeVO> list = new ArrayList();
		
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from AccounttypeVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AccounttypeVO> getAccounttypeById(int id) {
		List<AccounttypeVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from AccounttypeVO where status = true and accounttypeid = " + id);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
