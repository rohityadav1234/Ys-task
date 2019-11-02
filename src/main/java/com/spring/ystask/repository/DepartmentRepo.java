package com.spring.ystask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ystask.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

	Department findBydepartmentId(int departmentId);

}
