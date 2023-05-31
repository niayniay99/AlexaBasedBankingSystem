package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.model.LoantypeVO;

@Repository
public class LoantypeDaoImpl implements LoantypeDao {

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public void save(LoantypeVO loantypeVO) {
		try {
			
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(loantypeVO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<LoantypeVO> getLoantype() {
		List<LoantypeVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from LoantypeVO where status = true");
			list = q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<LoantypeVO> getLoantypeById(int id) {
		List<LoantypeVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from LoantypeVO where status = true and loantypeid = " + id);
			list = q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	}
	
}
