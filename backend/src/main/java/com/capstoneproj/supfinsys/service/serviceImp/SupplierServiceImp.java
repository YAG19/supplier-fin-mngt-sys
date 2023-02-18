package com.capstoneproj.supfinsys.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Supplier;
import com.capstoneproj.supfinsys.repository.SupplierRepository;
import com.capstoneproj.supfinsys.service.SupplierService;

@Service
public class SupplierServiceImp implements SupplierService {
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

}
