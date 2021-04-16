package com.callor.word.service;

import com.callor.word.model.WordVO;

public interface QuizService {

	public void mainMenu();
	public void saveGame();
	public void readWord();
	public Integer loadGame();
	public WordVO shuffleWord();
	public void playGame();
}
