package com.mustakim.springBoot.practice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mustakim.springBoot.practice.entity.Department;
import com.mustakim.springBoot.practice.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {

		Department department = Department.builder().departmentName("CSE").build();
		
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CSE")).thenReturn(department);
	}

	@Test
	@DisplayName("Validate Department Name Method")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {

		String departmentName = "CSE";

		Department existing = departmentService.fetchDepartmentByName(departmentName);

		assertEquals(departmentName, existing.getDepartmentName());
	}
}
