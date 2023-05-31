package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.LoantypeVO;
import com.demo.service.LoantypeService;

@Controller
public class LoantypeController {

	@Autowired
	LoantypeService loantypeService;

	@GetMapping(value = "admin/addLoantype")
	public ModelAndView addLoantype() {
		return new ModelAndView("admin/addLoantype", "LoantypeVO", new LoantypeVO());
	}

	@GetMapping(value = "admin/viewLoantype")
	public ModelAndView viewLoantype() {
		List<LoantypeVO> loantypeList = this.loantypeService.getLoantype();
		return new ModelAndView("admin/viewLoantype", "loantypeList", loantypeList);
	}

	@PostMapping(value = "admin/saveLoantype")
	public ModelAndView saveLoantype(@ModelAttribute LoantypeVO loantypeVO) {
		this.loantypeService.save(loantypeVO);
		return new ModelAndView("redirect:admin/viewLoantype");
	}

	@GetMapping(value = "admin/deleteLoantype")
	public ModelAndView deleteLoantype(@RequestParam int id) {
		List<LoantypeVO> loantypeList = this.loantypeService.getLoantypeById(id);

		LoantypeVO loantypeVO = loantypeList.get(0);
		loantypeVO.setStatus(false);

		loantypeService.save(loantypeVO);

		return new ModelAndView("redirect:admin/viewLoantype");
	}

	@GetMapping(value = "admin/editLoantype")
	public ModelAndView editLoantype(@RequestParam int id) {
		List<LoantypeVO> loantypeList = this.loantypeService.getLoantypeById(id);
		return new ModelAndView("admin/addLoantype", "LoantypeVO",loantypeList.get(0));
	}

}
