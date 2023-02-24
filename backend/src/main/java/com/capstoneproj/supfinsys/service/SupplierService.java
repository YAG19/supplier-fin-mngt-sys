package com.capstoneproj.supfinsys.service;

import com.capstoneproj.supfinsys.models.SupplierDto;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Supplier;

@Service("SupplierService")
public interface SupplierService {
	
	Supplier createSupplier(SupplierDto supplier);

}
