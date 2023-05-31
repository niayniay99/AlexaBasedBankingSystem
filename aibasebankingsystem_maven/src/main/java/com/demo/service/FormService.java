package com.demo.service;

import java.util.List;

import com.demo.model.FormVO;

public interface FormService {

	void save(FormVO formVO);

	List<FormVO> getForm();

	List<FormVO> getFormById(int id);

}
