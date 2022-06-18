package com.mustakim.springBoot.practice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentID;
	@NotBlank(message="Please Enter Department Name")
	@Length(max = 5,min=3)
	private String departmentName;
	private String departmentCode;
	private String departmentAddress;
}
