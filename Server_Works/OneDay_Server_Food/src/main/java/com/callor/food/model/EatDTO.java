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

	private String mf_date;// 날짜,
	private String fd_name;// AS 식품명,
	private int mf_eat;// AS 섭취량,
	private int mf_kcal;// 총에너지,
	private int mf_protein;// 단백질,
	private int mf_fat;//지방,
	private int mf_carbohydrate;//탄수화물,
	private int mf_sugar;//당류
}
