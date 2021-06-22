package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreVO;
import com.callor.score.pesistance.ScoreDAO;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ScoreV1")
public class ScoreServiceImplV1 implements ScoreService{
	
	protected final ScoreDAO scoreDao;
	
	public ScoreServiceImplV1(ScoreDAO scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	@Override
	public int insert(ScoreVO vo) {
		// TODO  입력하기
		
		return scoreDao.insert(vo);
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO 성적 수정하기
		
		return scoreDao.update(vo);
	}

	@Override
	public int delete(String sc_stnum, String sc_subject) {
		// TODO 성적 삭제하기
		
		return scoreDao.delete(sc_stnum, sc_subject);
	}

	@Override
	public List<ScoreVO> findbyNum(String st_num) {
		// TODO 학번으로 점수출력하기
	
		return scoreDao.findbyNum(st_num);
	}

}
