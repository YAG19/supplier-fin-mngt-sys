package com.capstoneproj.supfinsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproj.supfinsys.models.Supplier;
public interface SupplierRepository  extends JpaRepository<Supplier, Integer> {

}
