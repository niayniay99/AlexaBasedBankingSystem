package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.AreaVO;
import com.demo.model.FormVO;

@Repository
public class FormDaoImpl implements FormDao {
	
	@Autowired
	SessionFactory sessionfactory;


	@Override
	public void save(FormVO formVO) {
		try {

			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(formVO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<FormVO> getForm() {
		List<FormVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("From FormVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}


	@Override
	public List<FormVO> getFormById(int formId) {
		List<FormVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from FormVO where status = true and formid = " + formId);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
