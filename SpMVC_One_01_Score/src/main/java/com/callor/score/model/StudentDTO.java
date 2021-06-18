package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

	private String st_num;//	    CHAR(8)	        PRIMARY KEY,
	private String st_name;//	    nVARCHAR2(20)	NOT NULL,
	private String st_dept;//	    nVARCHAR2(20)	NOT NULL,
	private String st_grade;//	NUMBER	        NOT NULL,
	private Integer st_subject;
	private Integer st_avg;
	
}
