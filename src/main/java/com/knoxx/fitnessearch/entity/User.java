package com.knoxx.fitnessearch.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.knoxx.fitnessearch.model.Food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Name can not be empty!")
	@Column(nullable = false)
	private String name;
	
	@NotEmpty(message = "Password can not be empty!")
	@Size(min = 6)
	@Column(nullable = false)
	private String password;
	
	@NotEmpty(message = "Email can not be empty!")
	@Column(nullable = false)
	private String email;
	
	@NotNull(message = "Weight can not be empty!")
	@Column(nullable = false)
	private Double weight;
	
	@NotNull(message = "Height can not be empty!")
	@Column(nullable = false)
	private Double height;
	
	@Column(name = "protein_day", nullable = true)
	private Double proteinPerDay;
	
	@Column(name = "carbo_day", nullable = true)
	private Double carboPerDay;
	
	@Column(name = "fat_day", nullable = true)
	private Double fatPerDay;
	
	@ManyToMany
	private List<Food> foods;
	
}
