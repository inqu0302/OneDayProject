package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/score")
public class ScoreController {
	
	protected final ScoreService scService;
	
	public ScoreController(ScoreService scService) {
		this.scService = scService;
	}
	
	
	@RequestMapping(value= {"/",""}, method=RequestMethod.GET)
	public String select(Model model, String st_num) {
		
		List<ScoreVO> scList = scService.findbyNum(st_num);
		
		model.addAttribute(scList);
		
		return "score";
	}

}
