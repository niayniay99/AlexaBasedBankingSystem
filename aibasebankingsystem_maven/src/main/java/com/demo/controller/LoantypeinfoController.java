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
import com.demo.model.LoantypeinfoVO;
import com.demo.service.LoantypeService;
import com.demo.service.LoantypeinfoService;

@Controller
public class LoantypeinfoController {
	@Autowired
	private LoantypeService loantypeService;

	@Autowired
	private LoantypeinfoService loantypeinfoService;
	
	@GetMapping(value = "admin/addLoantypeinfo")
	public ModelAndView addLoantypeinfo() {
		List<LoantypeVO> loantypeList = this.loantypeService.getLoantype();
		return new ModelAndView("admin/addLoantypeinfo","LoantypeinfoVO",new LoantypeinfoVO()).addObject("loantypeList", loantypeList);
	}

	@GetMapping(value = "admin/viewLoantypeinfo")
	public ModelAndView viewLoantypeinfo() {
		List<LoantypeinfoVO> loantypeinfoList = this.loantypeinfoService.getLoantypeinfo();
		return new ModelAndView("admin/viewLoantypeinfo","loantypeinfoList",loantypeinfoList);
	}
	
	@PostMapping(value = "admin/saveLoantypeinfo")
	public ModelAndView saveLoantypeinfo(@ModelAttribute LoantypeinfoVO loantypeinfoVO) {
		this.loantypeinfoService.save(loantypeinfoVO);
		return new ModelAndView("redirect:admin/viewLoantypeinfo");
	}
	
	@GetMapping(value = "admin/deleteLoantypeinfo")
	public ModelAndView deleteLoantypeinfo(@RequestParam int id) {
		List<LoantypeinfoVO> loantypeinfoList = this.loantypeinfoService.getLoantypeinfoById(id);

		LoantypeinfoVO loantypeinfoVO = loantypeinfoList.get(0);
		
		loantypeinfoVO.setStatus(false);

		loantypeinfoService.save(loantypeinfoVO);

		return new ModelAndView("redirect:admin/viewLoantypeinfo");
	}

	@GetMapping(value = "admin/editLoantypeinfo")
	public ModelAndView editBranch(@RequestParam int id) {
		List<LoantypeinfoVO> loantypeinfoList = this.loantypeinfoService.getLoantypeinfoById(id);
		List<LoantypeVO> loantypeList = this.loantypeService.getLoantype();
		return new ModelAndView("admin/addLoantypeinfo", "LoantypeinfoVO", loantypeinfoList.get(0)).addObject("loantypeList", loantypeList);
	}

	
}
