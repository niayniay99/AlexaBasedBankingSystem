package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.BranchVO;

@Repository
public class BranchDaoImpl implements BranchDao{

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public void save(BranchVO branchVO) {
		try {
			Session session = this.sessionfactory.getCurrentSession();
			session.saveOrUpdate(branchVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public List<BranchVO> getBranch() {
		List<BranchVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from BranchVO where status = true");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BranchVO> getBranchById(int branchid) {
		List<BranchVO> list = new ArrayList();
		try {
			Session session = this.sessionfactory.getCurrentSession();
			Query q = session.createQuery("from BranchVO where status = true and branchid = " + branchid);
			list = q.list();
			
		} catch (Exception e) {e.printStackTrace();
		}
		return list;
	}
	
}
