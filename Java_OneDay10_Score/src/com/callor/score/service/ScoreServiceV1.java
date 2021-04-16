package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	protected List<String> nameList;
	int index = 0;
	int subject = 5;
	Integer intScore = 0;
	
	public ScoreServiceV1() {
		//TODO 생성자
		
		scan = new Scanner (System.in);
		scoreList = new ArrayList<ScoreVO>();
		nameList = new ArrayList<String>();
		
	}
	
	public void selectMenu() {
		//TODO 메뉴선택
		
		
		while(true) {
			String menu = null; // 입력받은 메뉴를 저장할 변수
			Integer intMenu = 0;
			System.out.println("=".repeat(60));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("-".repeat(60));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(60));
			System.out.print("업무선택 >> ");
			menu = scan.nextLine();
			
			if(menu.equals("QUIT")) {
				break;
			}
			try { // 메뉴선택시 잘못입력된 경우
				intMenu = Integer.valueOf(menu);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			
			if (intMenu == 1) {
				this.inputName();
			} else if (intMenu == 2){
				this.printScore();
			} else {//정해진메뉴가아닌 다른석택을 했을경우
				System.out.println("메뉴를 확인해 주세요");
				continue;
			}	
		}//end while
		
	}//END selectMenu
	
	public void inputName() {
		//TODO 이름입력
		
		String name = null;
		while(true) {
			System.out.println("=".repeat(60));
			System.out.println("학생이름을 입력하세요 (입력을 중단하려면 QUIT)");
			System.out.println("=".repeat(60));
			System.out.print("이름 >> ");
			name = scan.nextLine();
			if(name.equals("QUIT")) {
				return;
			} else if(name.equals(" ")) {
				System.out.println("이름을 입력하세요");
				continue;
			}
			break;
		}
		nameList.add(name);
		this.inputScore();
		
	}//END inputName
		
	public void inputScore() {
		// TODO 점수입력
		Integer intKor = 0;
		Integer intEng = 0;
		Integer intMath = 0;
		Integer intScience = 0;
		Integer intHistory = 0;
		
		intScore = 0;
		System.out.println("=".repeat(80));
		System.out.println(nameList.get(index) +
					"의 성적을 입력하세요 ( 성적범위 : 0 ~ 100,"
					+ " 입력을 중단하려면 QUIT)");
		System.out.println("=".repeat(80));

		intKor = this.scoreCheck("국어");
		if(intKor == null) {
			return;
			}
		
		 intEng = this.scoreCheck("영어");
		 if(intEng == null) {
				return;
			}
		 
		 intMath = this.scoreCheck("수학");
		 if(intMath == null) {
				return;
			}
		 
		 intScience = this.scoreCheck("과학");
		 if(intScience == null) {
				return;
			}
		 
		 intHistory = this.scoreCheck("국사");
		 if(intHistory == null) {
				return;
			}
			
		ScoreVO vo = new ScoreVO();
		vo.setIntKor(intKor);
		vo.setIntEng(intEng);
		vo.setIntMath(intMath);
		vo.setIntScience(intScience);
		vo.setIntHistory(intHistory);
		
		Integer totalScore = 0;
		float floatAvg = 0.0f;
		
		totalScore = (intKor + intEng + intMath + 
				intScience + intHistory);
		
		floatAvg = ((float)totalScore / subject) ;
		
		vo.setIntTotal(totalScore);
		vo.setFloatAvg(floatAvg);
		
		scoreList.add(vo);
		
		this.addScore();
	}// END inputScore
	
	public void addScore() {
		// TODO 점수추가 확인
		ScoreVO vo = scoreList.get(index);
		System.out.println("=".repeat(80));
		System.out.println(nameList.get(index) + 
				" 학생의 성적이 추가 되었습니다.");
		System.out.println("=".repeat(80));
		System.out.println("국어 : " + vo.getIntKor());
		System.out.println("영어 : " + vo.getIntEng());
		System.out.println("수학 : " + vo.getIntMath());
		System.out.println("과학 : " + vo.getIntScience());
		System.out.println("국사 : " + vo.getIntHistory());
		index++;
		return;
	}
	
	public void printScore() {
		//TODO 점수 출력
		
		System.out.println("=".repeat(80));
		System.out.println("순번\t이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println("-".repeat(80));
		for(int i = 0; i < scoreList.size(); i++) {
			System.out.print(i+1 + "\t");
			System.out.print(nameList.get(i) + "\t");
			ScoreVO vo = scoreList.get(i);
			System.out.print(vo.getIntKor() + "\t");
			System.out.print(vo.getIntEng() + "\t");
			System.out.print(vo.getIntMath() + "\t");
			System.out.print(vo.getIntScience() + "\t");
			System.out.print(vo.getIntHistory() + "\t");
			System.out.print(vo.getIntTotal() + "\t");
			System.out.printf("%3.2f\n" ,vo.getFloatAvg());
		}
		System.out.println("=".repeat(80));
		this.totalScore();
		
	}
	public void totalScore() {
		// TODO 전체총점 
		System.out.print("총점\t\t");
		Integer totalKor = 0;
		Integer totalMath = 0;
		Integer totalEng = 0;
		Integer totalScience = 0;
		Integer totalHistory = 0;
		Integer totalTotal = 0;
		float totalAvg = 0.0f;
		
		for (int i = 0 ; i < scoreList.size() ; i++) {
			ScoreVO vo = scoreList.get(i);
			totalKor += vo.getIntKor();
			totalMath += vo.getIntMath();
			totalEng += vo.getIntEng();
			totalScience += vo.getIntScience();
			totalHistory += vo.getIntHistory();
			totalTotal += vo.getIntTotal();
			totalAvg += vo.getFloatAvg();
		}
		
		totalAvg = totalAvg / scoreList.size() ;
		
		System.out.printf("%3d\t", totalKor);
		System.out.printf("%3d\t", totalEng);
		System.out.printf("%3d\t", totalMath);
		System.out.printf("%3d\t", totalScience);
		System.out.printf("%3d\t", totalHistory);
		System.out.printf("%3d\t", totalTotal);
		System.out.printf("%3.2f\n", totalAvg);
		
		System.out.println("=".repeat(80));
		
		return;
		
	}
	
	public Integer scoreCheck(String subject) {
		// TODO 유효성검사
		Integer score;
		while(true) {
			System.out.print(subject + " >>> ");
			String strScore = scan.nextLine();
			if (strScore.equals("QUIT")){
				return null;
			}
			try {
				score = Integer.valueOf(strScore);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("숫자만 입력해주세요");
				continue;
			}
			if(score > 100 || score < 0) {
				System.out.println("점수를 확인해주세요");
				continue; 
			}
			return score;
		}			
		
	}
	
}
	

