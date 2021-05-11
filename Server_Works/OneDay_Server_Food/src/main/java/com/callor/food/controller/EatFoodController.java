package com.callor.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.food.model.EatDTO;
import com.callor.food.model.EatVO;
import com.callor.food.model.FoodDTO;
import com.callor.food.service.EatService;
import com.callor.food.service.FoodService;
import com.callor.food.service.impl.EatServiceImplV1;
import com.callor.food.service.impl.FoodServiceImplV1;

@WebServlet("/eatfood/*")
public class EatFoodController extends HttpServlet{

	protected FoodService fdService;
	protected EatService etService;
	protected List<EatVO> eatList;
	protected String mf_date;
	protected String mf_code;
	protected String strEat;
	
	public EatFoodController() {
		fdService = new FoodServiceImplV1();
		etService = new EatServiceImplV1();
		eatList = new ArrayList<EatVO>();

		mf_date = null;
		mf_code = null;
		strEat = null;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String subPath = req.getPathInfo();
		
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		if(subPath == null) {
			
			req.getRequestDispatcher("/WEB-INF/views/eatfood.jsp").forward(req, resp);
			
		} else if(subPath.equals("/insert")) {
			
			req.getRequestDispatcher("/WEB-INF/views/foodInsert.jsp").forward(req, resp);
			
		} else if (subPath.equals("/insert/page1")) {
			
			mf_date = req.getParameter("date");
			
			System.out.println(mf_date);
			System.out.println(mf_code);
			if(mf_date == null || mf_date.equals("")) {
				out.println("날짜를 입력해주세요");
				out.close();
			}else {
				req.getRequestDispatcher("/WEB-INF/views/foodInsert2.jsp").forward(req, resp);
			}
		} else if (subPath.equals("/insert/page2")) {
			String fd_name = req.getParameter("title");
			
			System.out.println(fd_name);
			List<FoodDTO> fdList = this.fdService.findBytitle(fd_name);
			req.setAttribute("FOOD", fdList);
			req.getRequestDispatcher("/WEB-INF/views/foodInsert3.jsp").forward(req, resp);
		} else if (subPath.equals("/insert/page3")) {
			mf_code = req.getParameter("fd_code");

			System.out.println(mf_date);
			System.out.println(mf_code);
			
			req.getRequestDispatcher("/WEB-INF/views/foodInsert4.jsp").forward(req, resp);
		} else if (subPath.equals("/insert/page4")) {
			int mf_eat = 0;
			strEat = req.getParameter("eat");
			try {
				mf_eat = Integer.valueOf(strEat);
			} catch (Exception e) {
				out.println("숫자만입력해주세요");
			}
			
			System.out.println(mf_date);
			System.out.println(mf_code);
			strEat = req.getParameter("eat");
			
			EatVO eatVO = new EatVO();
			eatVO.setMf_date(mf_date);
			eatVO.setMf_code(mf_code);
			eatVO.setMf_eat(mf_eat);
			eatList.add(eatVO);
			
			System.out.println(eatList.toString());
			int result = this.etService.insert(eatVO);
			
			if(result == 1) {
				resp.sendRedirect("/food");
			} else {
				out.print("등록실패 처음부터 다시실행 해 주세요");
			} 
			
			
		} else if (subPath.equals("/select")) {
			req.getRequestDispatcher("/WEB-INF/views/foodSelect.jsp").forward(req, resp);
			
		} else if (subPath.equals("/select/page2")) {
			String strYear = req.getParameter("year");
			String strMonth = req.getParameter("month");
			String strDay = req.getParameter("day");
			
			int year = 0;
			int month = 0;
			int day = 0;
			try {
				year = Integer.valueOf(strYear);
				month = Integer.valueOf(strMonth);
				day = Integer.valueOf(strDay);
			} catch (NumberFormatException e) {
				out.println("숫자만 입력해주세요");
				e.printStackTrace();
			}
			
			String mf_date = String.format("%d-%02d-%02d", year, month, day);
			
			System.out.println(mf_date);
			List<EatDTO> eatList = this.etService.findByDate(mf_date);
			
			req.setAttribute("EAT", eatList);
			req.getRequestDispatcher("/WEB-INF/views/foodSelect2.jsp").forward(req, resp);
			
		}
		
		
	}// end doget

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}

	
	
}
