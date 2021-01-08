package com.ggq.worldtree.usercenter.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
	MALE(1, "男"), FEMALE(0, "女"),DEFAULT(2,"保密");

	private int value;
	private String desc;
	
	public static Gender getValue(int value){
	  for(Gender gender : values()){
	    if(gender.getValue() == value){
	      return gender;
	    }
	  }
	  return DEFAULT;
	}
}
