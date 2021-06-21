package com.callor.score.pesistance.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.callor.score.model.ScoreVO;
import com.callor.score.pesistance.ScoreDAO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.impl.ScoreServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("ScoreDaoV1")
public class ScoreDaoImplV1 implements ScoreDAO<ScoreVO, String>{

	protected final ScoreServiceImplV1 ScoreV1;
	
	public ScoreDaoImplV1(ScoreServiceImplV1 ScoreV1) {
		this.ScoreV1 = ScoreV1;
	}
	
	@Override
	public int insert(ScoreVO vo) {
		return this.ScoreV1.insert(vo);
	}

	@Override
	public int update(ScoreVO vo) {
		return this.ScoreV1.update(vo);
	}

	@Override
	public int delete(String sc_stnum, String sc_subject) {
		return this.ScoreV1.delete(sc_stnum, sc_subject);
	}

	@Override
	public List<ScoreVO> findbyNum(String st_num) {
		return this.ScoreV1.findbyNum(st_num);
	}

}
