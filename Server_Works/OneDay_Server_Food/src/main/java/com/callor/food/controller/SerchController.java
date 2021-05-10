package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.FoodDTO;
import com.callor.food.service.FoodService;
import com.callor.food.service.impl.FoodServiceImplV1;

@WebServlet("/serch/*")
public class SerchController extends HttpServlet{

	protected FoodService fdService;
	
	public SerchController() {
		fdService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		if(subPath == null) {
			req.getRequestDispatcher("/WEB-INF/views/serch.jsp").forward(req, resp);
		
		}else if(subPath.equals("/selectAll")) {
			System.out.println("selectAll 실행");
			List<FoodDTO> foodList = fdService.selectAll();
			ServletContext app = this.getServletContext();
			app.setAttribute("FOOD", foodList);
			System.out.println(foodList);
			req.getRequestDispatcher("/WEB-INF/views/serchfood.jsp").forward(req, resp);
		}
	}
	
	
}
