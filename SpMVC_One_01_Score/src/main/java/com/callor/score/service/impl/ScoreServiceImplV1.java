package com.callor.score.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.callor.score.model.ScoreVO;
import com.callor.score.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ScoreV1")
public class ScoreServiceImplV1 implements ScoreService{

	protected final JdbcTemplate JdbcTemplate;
	
	public ScoreServiceImplV1(JdbcTemplate JdbcTemplate) {
		this.JdbcTemplate = JdbcTemplate;
	}
	
	@Override
	public int insert(ScoreVO vo) {
		// TODO  입력하기
		
		String sql = " INSERT INTO tbl_score ";
		sql += " (sc_seq, sc_stnum, sc_subject, sc_score) ";
		sql += " VALUES( seq_score.nextval, ?, ?, ?) ";
		
		Object[] params = new Object[] {
						vo.getSc_stnum(),
						vo.getSc_subject(),
						vo.getSc_score()
		};
		
		return JdbcTemplate.update(sql, params);
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO 성적 수정하기
		
		String sql = " UPDATE tbl_score SET ";
		sql += " sc_stnum = ?, ";
		sql += " sc_subject = ?, ";
		sql += " sc_score = ? ";
		sql += " WHERE sc_seq = ? ";
		
		Object[] params = new Object[] {
						vo.getSc_stnum(),
						vo.getSc_subject(),
						vo.getSc_score(),
						vo.getSc_seq()
		};
		
		return JdbcTemplate.update(sql, params);
	}

	@Override
	public int delete(String sc_stnum, String sc_subject) {
		// TODO 성적 삭제하기
		
		String sql = " DELETE FROM tbl_score ";
		sql += " WHERE sc_stNum = ? AND sc_subject = ? ";
		
		Object[] params = new Object[] {
				sc_stnum, sc_subject };
		
		return JdbcTemplate.update(sql, params);
	}

	@Override
	public List<ScoreVO> findbyNum(String st_num) {
		// TODO 학번으로 점수출력하기
	
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE SC_STNUM = ? ";
		
		Object[] params = new Object[] {st_num};
		
		List<ScoreVO> score = JdbcTemplate.query(sql, params, new BeanPropertyRowMapper<ScoreVO>(ScoreVO.class));
		
		return score;
	}

}
