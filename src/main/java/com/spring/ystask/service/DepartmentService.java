package com.spring.ystask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ystask.dto.DepartmentDto;
import com.spring.ystask.entity.Department;
import com.spring.ystask.enums.YsTaskException;
import com.spring.ystask.exceptions.DepartmentException;
import com.spring.ystask.repository.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepo departmentRepo;

	public Department addDepartments(DepartmentDto dto) throws DepartmentException {
		
		Department dmt;
		dmt = departmentRepo.findBydepartmentId(dto.getDepartmentId());
		if(dmt != null) {
			throw new DepartmentException("Department id is already exist", YsTaskException.ALREADY_EXIST);
		}
		dmt = new Department();
		dmt.setDepartmentId(dto.getDepartmentId());
		dmt.setDepartmentName(dto.getDepartmentName());
		departmentRepo.save(dmt);
		return dmt;
	}

	public List<Department> getDepartments() throws DepartmentException {
		List<Department> dmt = departmentRepo.findAll();
		if(dmt.isEmpty()) {
			throw new DepartmentException("Department not found", YsTaskException.DEPARTMENT_NOT_FOUND);
		}
		return dmt;
	}

	public Department updateDepartments(int departmentId, String departmentName) throws DepartmentException {
		Department dmt = departmentRepo.findBydepartmentId(departmentId);
		if(dmt ==null) {
			throw new DepartmentException("Department not found", YsTaskException.DEPARTMENT_NOT_FOUND);
		}
		dmt.setDepartmentName(departmentName);
		departmentRepo.save(dmt);
		return dmt;
	}

	public void deleteDepartments(int departmentId) throws DepartmentException {
		Department dmt = departmentRepo.findBydepartmentId(departmentId);
		if(dmt ==null) {
			throw new DepartmentException("Department not found", YsTaskException.DEPARTMENT_NOT_FOUND);
		}
		departmentRepo.delete(dmt);		
	}

}
