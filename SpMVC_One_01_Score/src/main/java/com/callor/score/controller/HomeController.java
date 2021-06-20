package com.callor.score.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentDTO;
import com.callor.score.service.impl.StudentsServiceImplV1;

@Controller
public class HomeController {

	@Value("${student}")
	protected StudentDTO studentDTO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("student", StudentsServiceImplV1.this.selectAll());
		
		
		return "home";
	}
	
}
