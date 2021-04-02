package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreServiceV1 {

	protected Scanner scan;
	protected List<Integer> scoreList;
	
	public ScoreServiceV1() {
		scan = new Scanner (System.in);
		scoreList = new ArrayList<Integer>();
		
	}
	
	public void selectMenu() {
		String menu = null;
		while(true) {
			System.out.println("=".repeat(60));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("-".repeat(60));
			System.out.println("1. 학생병 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUTI. 업무종료");
			System.out.println("=".repeat(60));
			System.out.print("업무선택 >> ");
			menu = scan.nextLine();
			
			if(menu.equals("QUIT"))
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
