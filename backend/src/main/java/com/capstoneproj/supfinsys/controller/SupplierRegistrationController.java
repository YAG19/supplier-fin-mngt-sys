package com.capstoneproj.supfinsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.Supplier;
import com.capstoneproj.supfinsys.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierRegistrationController {
	@Autowired
    SupplierService supplierService;
	
	@PostMapping("/registration")
	public Supplier  supplierRegistration(@RequestBody Supplier supplier)
	{
		return supplierService.createSupplier(supplier);
	}
	

}
