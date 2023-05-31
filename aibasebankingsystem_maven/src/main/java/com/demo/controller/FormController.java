package com.demo.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.FormVO;
import com.demo.service.FormService;

@Controller
public class FormController {

	@Autowired
	private FormService formService;

	@GetMapping(value = "admin/addForm")
	public ModelAndView addForm() {
		return new ModelAndView("admin/addForm", "FormVO", new FormVO());
	}

	@GetMapping(value = "admin/viewForm")
	public ModelAndView viewForm() {
		List<FormVO> formList = this.formService.getForm();
		return new ModelAndView("admin/viewForm", "formList", formList);
	}

	@PostMapping(value = "admin/saveForm")
	public ModelAndView saveForm(@RequestParam String fileName, @RequestParam MultipartFile file, HttpSession session) {

		FormVO formVO = new FormVO();
		formVO.setFileName(fileName);

		if (file != null) {

			String path = session.getServletContext().getRealPath("/");

			String docName = file.getOriginalFilename();
			String docPath = path + "/docs";

			try {
				byte b[] = file.getBytes();
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(docPath + "/" + docName));

				bout.write(b);
				bout.flush();
				bout.close();

			} catch (Exception e) {e.printStackTrace();}
			
			formVO.setDocName(docName);
			formVO.setDocPath(docPath);
		}

		this.formService.save(formVO);
		return new ModelAndView("redirect:admin/viewForm");
	}
	
	@GetMapping(value = "admin/deleteForm")
	public ModelAndView deleteArea(@RequestParam int formId) {
		List<FormVO> formList = this.formService.getFormById(formId);

		FormVO formVO = formList.get(0);
		formVO.setStatus(false);

		formService.save(formVO);

		return new ModelAndView("redirect:admin/viewForm");
	}


}
