package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentDTO;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	protected final StudentService studentService;
	
	public HomeController(StudentService studentService) {
		
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<StudentDTO> studentList = studentService.selectScoreAndStudent();
		
		model.addAttribute("STUDENT", studentList);
		
		log.debug(studentList.toString());
		
		return "home";
	}
	
}
