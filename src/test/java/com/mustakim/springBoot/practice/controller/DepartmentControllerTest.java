package com.mustakim.springBoot.practice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;
import com.mustakim.springBoot.practice.entity.Department;
import com.mustakim.springBoot.practice.error.DepartmentNotFoundException;
import com.mustakim.springBoot.practice.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp() {
		department = Department.builder()
				.departmentAddress("Khulna")
				.departmentCode("EEE-20")
				.departmentName("ETE")
				.departmentID(1L)
				.build();
	}
	
	@Test
	void saveDepartment() throws Exception {
		
		Department inputDepartment = Department.builder()
				.departmentAddress("Khulna")
				.departmentCode("EEE-20")
				.departmentName("ETE")
				.build();
		
		Mockito.when(departmentService.saveDepartment(inputDepartment))
			   .thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/saveDepartment")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"departmentName\":\"ETE\",\r\n"
						+ "    \"departmentCode\":\"EEE-20\",\r\n"
						+ "    \"departmentAddress\":\"khulna\"\r\n"
						+ "}"
						)).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	void fetchDepartmentById() throws Exception {
		
		Mockito.when(departmentService.fetchDepartmentById(1L))
		.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
