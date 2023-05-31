package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.AreaVO;
import com.demo.model.LoantypeinfoVO;

@Repository
public class LoantypeinfoDaoImpl implements LoantypeinfoDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void save(LoantypeinfoVO loantypeinfoVO) {
		try {
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(loantypeinfoVO);
		} catch (Exception e) {e.printStackTrace();}		
	}

	@Override
	public List<LoantypeinfoVO> getLoantypeinfo() {
		List<LoantypeinfoVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from LoantypeinfoVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<LoantypeinfoVO> getLoantypeinfoById(int id) {
		List<LoantypeinfoVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from LoantypeinfoVO where status = true and loantypeinfoid = " + id);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
