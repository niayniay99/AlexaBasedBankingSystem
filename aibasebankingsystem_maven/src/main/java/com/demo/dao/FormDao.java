package com.demo.dao;

import java.util.List;

import com.demo.model.FormVO;

public interface FormDao {

	 void save(FormVO formVO);

	List<FormVO> getForm();

	List<FormVO> getFormById(int formId);

}
