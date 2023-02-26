package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.exception.ResponseMessage;
import com.capstoneproj.supfinsys.exception.UsernameAlreadyExistsException;
import com.capstoneproj.supfinsys.models.SupplierDto;
import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capstoneproj.supfinsys.service.SupplierService;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
	@Autowired
    SupplierService supplierService;

	@Autowired
	UserService userService;
	
	@PostMapping("/registration")
	ResponseEntity<ResponseMessage> supplierRegistration(@RequestBody SupplierDto supplierDto)
	{
		String username = supplierDto.getUsername();
		if(userService.clientUsernameExists(username)) {
			throw new UsernameAlreadyExistsException("Username Already Exists");
		}
		supplierService.createSupplier(supplierDto);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Registered"));
	}
	

}
