package com.callor.score.pesistance;

import java.util.List;


public interface ScoreDAO <ScoreVO, String>{

	public int insert(ScoreVO vo);
	
	public int update(ScoreVO vo);
	
	public int delete(String sc_stnum, String sc_subject);
	
	public List<ScoreVO> findbyNum(String st_num);
}
