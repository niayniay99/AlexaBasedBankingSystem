package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AreaDao;
import com.demo.dao.FormDao;
import com.demo.model.FormVO;

@Service
@Transactional
public class FormServiceImpl implements FormService {
	
	@Autowired
	private FormDao formDao;

	@Override
	public void save(FormVO formVO) {
		this.formDao.save(formVO);
		
	}

	@Override
	public List<FormVO> getForm() {
		return this.formDao.getForm();
	}

	@Override
	public List<FormVO> getFormById(int formId) {
		return this.formDao.getFormById(formId);
	}

}
