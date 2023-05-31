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
import com.demo.model.BranchVO;
import com.demo.service.AreaService;
import com.demo.service.BranchService;

@Controller
public class BranchController {

	@Autowired
	private AreaService areaService;
	
	@Autowired
	private BranchService branchService;
	
	@GetMapping(value = "admin/addBranch")
	public ModelAndView addBranch() {
		List<AreaVO> areaList = this.areaService.getArea();
		return new ModelAndView("admin/addBranch","BranchVO",new BranchVO()).addObject("areaList", areaList);
	}

	@GetMapping(value = "admin/viewBranch")
	public ModelAndView viewBranch() {
		List<BranchVO> branchList = this.branchService.getBranch();
		
		return new ModelAndView("admin/viewBranch","branchList",branchList);
	}
	
	@PostMapping(value = "admin/saveBranch")
	public ModelAndView saveBranch(@ModelAttribute BranchVO branchVO) {
		this.branchService.save(branchVO);
		return new ModelAndView("redirect:viewBranch");
	}

	@GetMapping(value = "admin/deleteBranch")
	public ModelAndView deleteBranch(@RequestParam int branchid) {
		List<BranchVO> branchList = this.branchService.getBranchById(branchid);

		BranchVO branchVO = branchList.get(0);
		
		branchVO.setStatus(false);

		branchService.save(branchVO);

		return new ModelAndView("redirect:viewBranch");
	}

	@GetMapping(value = "admin/editBranch")
	public ModelAndView editBranch(@RequestParam int branchid) {
		List<BranchVO> branchList = this.branchService.getBranchById(branchid);
		List<AreaVO> areaList = this.areaService.getArea();
		return new ModelAndView("admin/addBranch", "BranchVO", branchList.get(0)).addObject("areaList", areaList);
	}


}
