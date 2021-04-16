package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;
import com.callor.word.service.LogServiceV1;
import com.callor.word.service.QuizService;

public class QuizServiceImplV1 implements QuizService {
	// TODO 사용 유틸들
	protected Scanner scan;
	protected Random rnd;

	// TODO 사용 메서드들
	protected LogServiceV1 logService;

	// TODO 사용 리스트들
	protected List<WordVO> wordList;

	// TODO 사용 변수들
	protected final int 영어 = 0;
	protected final int 한글 = 1;
	private int score;
	private Integer saveScore;
	
	
	public QuizServiceImplV1() {
		// TODO 생성자

		// 유틸
		scan = new Scanner(System.in);
		rnd = new Random();

		// 메서드
		logService = new LogServiceV1();

		// 리스트
		wordList = new ArrayList<WordVO>();

		this.readWord();
	}

	@Override
	public void mainMenu() {
		// TODO 게임시작 메인메뉴

		while (true) {

			System.out.println("=".repeat(50));
			System.out.println("\t 영 단어 QUIZ");
			System.out.println("-".repeat(50));
			System.out.println("1. 게임 시작!");
			System.out.println("2. 게임 저장");
			System.out.println("3. 저장된 게임 불러오기");
			System.out.println("QUIT : 게임 종료");
			System.out.println("=".repeat(50));
			System.out.print("메뉴를 선택해 주세요 : ");
			String menu = scan.nextLine();

			if (menu.trim().equals("QUIT"))
				return;

			Integer intMenu = null;
			try {
				intMenu = Integer.valueOf(menu);
			} catch (NumberFormatException e) {
				System.out.println("보기에 있는 메뉴만 선택해주세요");
				continue;
			}

			if (intMenu == 1)
				this.playGame();
			else if (intMenu == 2)
				this.saveGame();
			else if (intMenu == 3)
				saveScore = this.loadGame();

		}

	} // End MainMenu

	@Override
	public void readWord() {
		// TODO 단어 불러오기

		String wordAdd = "src/com/callor/word/word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {

			fileReader = new FileReader(wordAdd);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;
				String[] word = reader.split(":");
				WordVO vo = new WordVO();
				vo.setEng(word[영어]);
				vo.setKor(word[한글]);
				wordList.add(vo);

			}

			// 파일 불러오는중 오류발생
		} catch (FileNotFoundException e) {
			System.out.println("단어생성 오류");
			logService.Log(wordAdd + "파일 경로에 문제발생!");
		} catch (IOException e) {
			System.out.println("단어생성 오류");
			logService.Log(wordAdd + " 파일을 읽어들이는동안 문제발생!");
		}

	} // End ReadWord

	@Override
	public void playGame() {
		// TODO 게임 진행하기
		score = 10;
		if(saveScore!=null) {
			score = saveScore;
			System.out.println("저장된 점수는 : " + saveScore + "점 입니다.");
		}
		while(true) {
			WordVO vo = this.shuffleWord();
			System.out.println("=".repeat(80));
			System.out.println("게임을 시작합니다. 다음 단어를 바르게 배열하시오 ( QUIT : 게임종료)");
			String[] word = vo.getShuffleEng();
			int count = 3;
			if(score <= 0) {
				System.out.println("Game Over");
				return;
			}
			// 중복 while문 메서드로 분리해보기
			while (true) {
				System.out.println("=".repeat(80));
				System.out.println(Arrays.toString(word) + "\t 현재 점수 ( " + score + "점 )\t남은기회 : " + count);
				System.out.println("다음문제로 넘어가려면 : PASS 를 입력하세요");
				System.out.println("힌트를 원하시면 [ HINT ] 를 입력하세요 점수를 1점 차감합니다");
				System.out.println(vo.getEng());
				System.out.println("=".repeat(80));
				System.out.print(">>> ");
				String input = scan.nextLine();
				
				// if 지옥 메서드로 분리해서 탈출시키기
				if (input.equals("QUIT")) {
					System.out.println("게임을 종료합니다.");
					return;
				} else if (input.equals("PASS")) {
					break;
				} else if (input.equals("HINT")) {
					if(score <= 0) {
						System.out.println("점수가 부족해 힌트를 볼 수 없습니다.");
						continue;
					}
					System.out.print("이 단어는 이런 뜻을 가지고 있습니다 : ");
					System.out.println(vo.getKor());
					score--;
					continue;
				}
				count--;
				if(input.equals(vo.getEng())) {
					System.out.println("정답입니다!!");
					System.out.print(vo.getEng() + " : ");
					System.out.println(vo.getKor());
					score += 5;
					System.out.println("당신의 점수는 : " + score);
					break;
				} else {
					System.out.println("오답입니다.");
					score -= 2;
				}
				
				if (count <= 0) {
					break;
				}
			}
			
		}

	}

	@Override
	public WordVO shuffleWord() {
		// TODO 단어 섞기
		int rndNum = rnd.nextInt(wordList.size());

		WordVO vo = new WordVO();

		vo = wordList.get(rndNum);
		String strEng = vo.getEng();
		String[] word = strEng.split("");
		for (int i = 0; i < 100; i++) {
			int index1 = rnd.nextInt(word.length);
			int index2 = rnd.nextInt(word.length);

			String temp = word[index1];

			word[index1] = word[index2];
			word[index2] = temp;

		}

		vo.setShuffleEng(word);

		return vo;
	}

	@Override
	public void saveGame() {
		// TODO 게임 진행상황 저장하기
		String inputName = null; 
		
		while(true) {
			System.out.println("저장할 파일 이름을 입력해주세요");
			System.out.print(">>>  ");
			inputName = scan.nextLine();
			
			if(inputName.equals("")) {
				System.out.println("파일이름은 반드시 입력해야합니다.");
				continue;
			}
			break;
		}
		String fileName = String.format("src/com/callor/word/%s.txt", inputName);
		
		FileWriter fileWriter = null;
		PrintWriter out = null;
		
		try {
			fileWriter = new FileWriter(fileName);
			out = new PrintWriter(fileWriter);
			
			out.println(score);
			
			out.flush();
			out.close();
			
		} catch (IOException e) {
			System.out.println("저장불가");
			logService.Log("입력값 : " + fileName + "저장장소 오류");
		}
		System.out.println("저장이 완료되었습니다.");
	}

	@Override
	public Integer loadGame() {
		// TODO 저장된 게임 불러오기
		
		while(true) {
			
			
			System.out.println("불러오실 파일 이름을 입력해 주세요 ( QUIT : 메뉴로 돌아가기 ) ");
			System.out.print(">>> ");
			String inputName = scan.nextLine();
			
			if(inputName.equals("QUIT")) {
				return null;
			}
			String fileName = String.format("src/com/callor/word/%s.txt", inputName);
			
			FileReader fileReader = null;
			BufferedReader buffer = null;
			
			try {
				fileReader = new FileReader(fileName);
				buffer = new BufferedReader(fileReader);
				String score = null;
				
				while(true) {
					score = buffer.readLine();
					if(score==null)break;
					saveScore = Integer.valueOf(score);
				}
				
				buffer.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("파일 이름이 잘못되었습니다.");
				System.out.println("확인 후 다시 입력해 주세요.");
				logService.Log("입력값 : " + fileName + "파일 불러오기 오류(파일이름 다름)");
				continue;
			} catch (IOException e) {
				System.out.println("파일을 불러오는중에 문제가 발생했습니다.");
				logService.Log("입력값 : " + fileName + "파일 불러오기 오류(읽기도중 오류)");
				return null;
			}
			System.out.println("불러오기 완료");
			return saveScore;
			
		}
	}

}
