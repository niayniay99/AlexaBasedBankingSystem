package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.AccounttypeVO;
import com.demo.service.AccounttypeService;

@Controller
public class AccounttypeController {

	@Autowired
	private AccounttypeService accounttypeService;

	@GetMapping(value = "admin/addAccounttype")
	public ModelAndView addAccounttype() {
		return new ModelAndView("admin/addAccounttype", "AccounttypeVO", new AccounttypeVO());
	}

	@GetMapping(value = "admin/viewAccounttype")
	public ModelAndView viewAccounttype() {
		List<AccounttypeVO> accounttypeList = this.accounttypeService.getAccounttype();

		return new ModelAndView("admin/viewAccounttype", "accounttypeList", accounttypeList);
	}

	@PostMapping(value = "admin/saveAccounttype")
	public ModelAndView saveAccounttype(@ModelAttribute AccounttypeVO accounttypeVO) {

		this.accounttypeService.save(accounttypeVO);
		return new ModelAndView("redirect:viewAccounttype");
	}

	@GetMapping(value = "admin/deleteAccounttype")
	public ModelAndView deleteAccounttype(@RequestParam int id) {
		List<AccounttypeVO> accounttypeList = this.accounttypeService.getAccounttypeById(id);

		AccounttypeVO accounttypeVO = accounttypeList.get(0);
		accounttypeVO.setStatus(false);

		accounttypeService.save(accounttypeVO);

		return new ModelAndView("redirect:admin/viewAccounttype");
	}

	@GetMapping(value = "admin/editAccounttype")
	public ModelAndView editAccounttype(@RequestParam int id) {
		List<AccounttypeVO> accounttypeList = this.accounttypeService.getAccounttypeById(id);
		return new ModelAndView("admin/addAccounttype", "AccounttypeVO", accounttypeList.get(0));
	}

}
