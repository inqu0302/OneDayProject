package com.callor.score.model;

public class ScoreVO {

	protected Integer intKor;
	protected Integer intEng;
	protected Integer intMath;
	protected Integer intScience;
	protected Integer intHistory;
	protected Integer intTotal;
	protected float floatAvg; 
	protected String strName;
	
	
	
	public Integer getIntTotal() {
		return intTotal;
	}
	public void setIntTotal(Integer intTotal) {
		this.intTotal = intTotal;
	}
	public float getFloatAvg() {
		return floatAvg;
	}
	public void setFloatAvg(float floatAvg) {
		this.floatAvg = floatAvg;
	}
	public Integer getIntKor() {
		return intKor;
	}
	public void setIntKor(Integer intKor) {
		this.intKor = intKor;
	}
	public Integer getIntEng() {
		return intEng;
	}
	public void setIntEng(Integer intEng) {
		this.intEng = intEng;
	}
	public Integer getIntMath() {
		return intMath;
	}
	public void setIntMath(Integer intMath) {
		this.intMath = intMath;
	}
	public Integer getIntScience() {
		return intScience;
	}
	public void setIntScience(Integer intScience) {
		this.intScience = intScience;
	}
	public Integer getIntHistory() {
		return intHistory;
	}
	public void setIntHistory(Integer intHistory) {
		this.intHistory = intHistory;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	
}
