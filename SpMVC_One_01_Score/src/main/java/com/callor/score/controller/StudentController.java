package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/student")

public class StudentController {
	
	protected final ScoreService scService;
	protected final StudentService stService;
	
	public StudentController(ScoreService scService, StudentService stService) {
		
		this.scService = scService;
		
		this.stService = stService;
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String select(Model model) {
		
		List<StudentVO> stList = stService.selectStudent();
		
		model.addAttribute("STLIST",stList);
				
		return "student";
	}

}
