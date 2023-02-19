package com.capstoneproj.supfinsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capstoneproj.supfinsys.models.Client;
import com.capstoneproj.supfinsys.models.Supplier;
import com.capstoneproj.supfinsys.service.SupplierService;


@CrossOrigin(origins = "http://localhost:8081")
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
