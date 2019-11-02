package com.spring.ystask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.ystask.dto.DepartmentDto;
import com.spring.ystask.dto.ErrorResponseDto;
import com.spring.ystask.dto.SuccessResponseDto;
import com.spring.ystask.entity.Department;
import com.spring.ystask.enums.SuccessCodes;
import com.spring.ystask.enums.YsTaskException;
import com.spring.ystask.exceptions.DepartmentException;
import com.spring.ystask.service.DepartmentService;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping(value = "/addDepartment")
	public ResponseEntity<?> addDepartment(@RequestBody DepartmentDto dto) throws DepartmentException {
		ErrorResponseDto erdto = new ErrorResponseDto();
		SuccessResponseDto sdto = new SuccessResponseDto();
		if (StringUtils.isEmpty(dto.getDepartmentId()) || StringUtils.isEmpty(dto.getDepartmentName())) {
			erdto.getMsg().add("field can not be empty");
			erdto.setException(YsTaskException.FIELD_CAN_NOT_BE_EMPTY);
			return ResponseEntity.ok().body(erdto);
		}
		Department dmt = departmentService.addDepartments(dto);
		sdto.getMsg().add("Department Added successfully");
		sdto.setSuccessCode(SuccessCodes.API_SUCCESS);
		sdto.getExtraData().put("department", dmt);
		return ResponseEntity.ok().body(sdto);

	}

	@GetMapping(value = "/get/department")
	public ResponseEntity<?> getDepartment() throws DepartmentException {
		SuccessResponseDto sdto = new SuccessResponseDto();
		List<Department> dmt = departmentService.getDepartments();
		sdto.getMsg().add("Department Record");
		sdto.setSuccessCode(SuccessCodes.API_SUCCESS);
		sdto.getExtraData().put("department", dmt);
		return ResponseEntity.ok().body(sdto);

	}

	@PutMapping(value = "/update/department")
	public ResponseEntity<?> updateDepartment(@RequestParam("departmentId") int departmentId,
			@RequestParam("departmentName") String departmentName)
			throws DepartmentException {
		ErrorResponseDto erdto = new ErrorResponseDto();
		SuccessResponseDto sdto = new SuccessResponseDto();
		if (StringUtils.isEmpty(departmentId) || StringUtils.isEmpty(departmentName)) {
			erdto.getMsg().add("field can not be empty");
			erdto.setException(YsTaskException.FIELD_CAN_NOT_BE_EMPTY);
			return ResponseEntity.ok().body(erdto);
		}
		Department dmt = departmentService.updateDepartments(departmentId,departmentName);
		sdto.getMsg().add("Department Name Updated");
		sdto.setSuccessCode(SuccessCodes.API_SUCCESS);
		sdto.getExtraData().put("department", dmt);
		return ResponseEntity.ok().body(sdto);

	}
	
	@DeleteMapping(value = "/delete/department")
	public ResponseEntity<?> deleteDepartment(@RequestParam("departmentId") int departmentId)throws DepartmentException {
		ErrorResponseDto erdto = new ErrorResponseDto();
		SuccessResponseDto sdto = new SuccessResponseDto();
		if (StringUtils.isEmpty(departmentId)) {
			erdto.getMsg().add("field can not be empty");
			erdto.setException(YsTaskException.FIELD_CAN_NOT_BE_EMPTY);
			return ResponseEntity.ok().body(erdto);
		}
		departmentService.deleteDepartments(departmentId);
		sdto.getMsg().add("Department deleted successfully");
		sdto.setSuccessCode(SuccessCodes.API_SUCCESS);
		return ResponseEntity.ok().body(sdto);

	}

}
