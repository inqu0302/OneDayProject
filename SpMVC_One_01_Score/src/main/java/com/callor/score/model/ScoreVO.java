package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScoreVO {

	private String sc_seq;//	    CHAR(8)	        PRIMARY KEY,
	private String sc_stnum;//	CHAR(8)	        NOT NULL,
	private String sc_subject;//	nVARCHAR2(20)	NOT NULL,
	private String sc_score;//	NUMBER	        NOT NULL
}
