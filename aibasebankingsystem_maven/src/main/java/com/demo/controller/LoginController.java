package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping(value = { "/", "/login" })
	public ModelAndView addArea() {
		return new ModelAndView("login");
	}

	@GetMapping(value = "admin/index")
	public ModelAndView index() {
		return new ModelAndView("admin/index");
	}
}
