package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreVO;


public interface ScoreService {

	public void insert(ScoreVO scoreVO);
	
	public void update(ScoreVO scoreVO);
	
	public void delet(String sc_stnum, String sc_subject);
	
	public List<ScoreVO> selectAll(String sc_stnum);
	
}
