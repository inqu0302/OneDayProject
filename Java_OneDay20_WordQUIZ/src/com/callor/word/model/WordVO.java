package com.callor.word.model;

import java.util.ArrayList;

public class WordVO {

	private String eng;
	private String kor;
	private Integer score;
	private String[] shuffleEng;
	
	
	public String[] getShuffleEng() {
		return shuffleEng;
	}
	public void setShuffleEng(String[] shuffleEng) {
		this.shuffleEng = shuffleEng;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
