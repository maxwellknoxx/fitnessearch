package com.knoxx.fitnessearch.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	private Double weight;
	private Double height;
	private Double proteinPerDay;
	private Double carboPerDay;
	private Double fatPerDay;
	
}
