package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eatfood/*")
public class EatFoodController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		if(subPath == null) {
			
			req.getRequestDispatcher("/WEB-INF/views/eatfood.jsp").forward(req, resp);
			
		} else if(subPath.equals("/insert")) {
			
			
		}
		
	}

	
}
