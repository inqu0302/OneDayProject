package com.callor.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.EatDTO;
import com.callor.food.service.EatService;
import com.callor.food.service.impl.EatServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{

	protected EatService etService;
	
	public HomeController() {
		etService = new EatServiceImplV1();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<EatDTO> eatList = this.etService.selectAll();
		
		req.setAttribute("EAT", eatList);
		
		req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
	}

	
}
