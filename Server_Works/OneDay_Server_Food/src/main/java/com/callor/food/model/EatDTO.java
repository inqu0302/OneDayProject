package com.callor.food.model;

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
public class EatDTO {

	private String mf_code;	//	char(7 byte)
	private String mf_date;	//	nvarchar2(10 char)
	private int mf_eat;		//	number
}
