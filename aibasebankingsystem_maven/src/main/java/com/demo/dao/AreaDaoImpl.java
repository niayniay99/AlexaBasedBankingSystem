package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.AreaVO;

@Repository
public class AreaDaoImpl implements AreaDao {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void save(AreaVO areaVO) {
		try {
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(areaVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AreaVO> getArea() {
		List<AreaVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from AreaVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<AreaVO> getAreaById(int areaId) {
		List<AreaVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from AreaVO where status = true and areaid = " + areaId);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
