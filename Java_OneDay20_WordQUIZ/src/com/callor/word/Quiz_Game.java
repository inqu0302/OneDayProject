package com.callor.word;

import com.callor.word.service.QuizService;
import com.callor.word.service.impl.QuizServiceImplV1;

public class Quiz_Game {

	public static void main(String[] args) {
		
		QuizService game = new QuizServiceImplV1();
				
		game.mainMenu();
	}
}
