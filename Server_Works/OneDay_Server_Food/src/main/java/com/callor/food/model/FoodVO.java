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
public class FoodVO {

	private String fd_code;	//	char(7 byte)
	private String fd_name;	//	nvarchar2(50 char)
	private String fd_year;	//	varchar2(4 byte)
	private String fd_ccode;	//	char(6 byte)
	private String fd_scode;	//	char(4 byte)
	private int fd_ssize;	//	number
	private int fd_gram;	//	number
	private int fd_kcal;	//	number
	private int fd_protein;	//	number
	private int fd_fat;		//	number
	private int fd_carbohydrate;	//	number
	private int fd_sugar;	//	number
}
