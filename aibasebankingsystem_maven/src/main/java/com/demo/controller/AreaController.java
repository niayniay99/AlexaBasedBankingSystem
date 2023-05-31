package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.AreaVO;
import com.demo.service.AreaService;

@Controller
public class AreaController {

	@Autowired
	private AreaService areaService;

	@GetMapping(value = "admin/addArea")
	public ModelAndView addArea() {
		return new ModelAndView("admin/addArea", "AreaVO", new AreaVO());
	}

	@GetMapping(value = "admin/viewArea")
	public ModelAndView viewArea() {
		List<AreaVO> areaList = this.areaService.getArea();
		return new ModelAndView("admin/viewArea", "areaList", areaList);
	}

	@PostMapping(value = "admin/saveArea")
	public ModelAndView saveArea(@ModelAttribute AreaVO areaVO) {
		this.areaService.save(areaVO);
		return new ModelAndView("redirect:admin/viewArea");
	}

	@GetMapping(value = "admin/deleteArea")
	public ModelAndView deleteArea(@RequestParam int id) {
		List<AreaVO> areaList = this.areaService.getAreaById(id);

		AreaVO areaVO = areaList.get(0);
		areaVO.setStatus(false);

		areaService.save(areaVO);

		return new ModelAndView("redirect:admin/viewArea");
	}

	@GetMapping(value = "admin/editArea")
	public ModelAndView editArea(@RequestParam int id) {
		List<AreaVO> areaList = this.areaService.getAreaById(id);
		return new ModelAndView("admin/addArea", "AreaVO", areaList.get(0));
	}

}
