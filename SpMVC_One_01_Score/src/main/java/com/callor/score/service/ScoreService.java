package com.callor.score.service;

import java.util.List;

import com.callor.score.model.ScoreVO;


public interface ScoreService {

	public int insert(ScoreVO vo);
	
	public int update(ScoreVO vo);
	
	public int delete(String sc_stnum, String sc_subject);
	
	public List<ScoreVO> findbyNum(String st_num);
	
}
