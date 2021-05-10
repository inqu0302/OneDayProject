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
public class FoodDTO {

	private String fd_code;
    private String fd_name;
    private String fd_year; 
    private String cp_name;
    private String it_name;
    private int fd_ssize;
    private int fd_gram;
    private int fd_kcal;
    private int fd_protein;
    private int fd_fat;
    private int fd_carbohydrate;
    private int fd_sugar;
}
