package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.models.SupplierDto;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Supplier;
import com.capstoneproj.supfinsys.repository.SupplierRepository;
import com.capstoneproj.supfinsys.service.SupplierService;

@Service
public class SupplierServiceImp implements SupplierService {
	@Autowired
	SupplierRepository supplierRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Supplier createSupplier(SupplierDto supplierDto) {

		User user = User.builder()
				.username(supplierDto.getUsername())
				.password(supplierDto.getPassword())
				.role("SUPPLIER")
				.build();

		Supplier supplier = Supplier.builder()
				.supplierEmail(supplierDto.getSupplierEmail())
				.supplierName(supplierDto.getSupplierName())
				.supplierMob(supplierDto.getSupplierMob())
				.supplierAddress(supplierDto.getSupplierAddress())
				.creditInfo(supplierDto.getCreditInfo())
				.creditAccNumber(supplierDto.getCreditAccNumber())
				.user(user)
				.build();
		user.setSupplier(supplier);
		userRepository.save(user);

		return supplier;
	}

}
