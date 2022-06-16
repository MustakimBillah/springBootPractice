package com.mustakim.springBoot.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mustakim.springBoot.practice.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}