package com.callor.food.model;

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

public class EatVO {

	private String mf_date;	//	nvarchar2(10 char)
	private String mf_code;	//	char(7 byte)
	private int mf_eat;		//	number
}
