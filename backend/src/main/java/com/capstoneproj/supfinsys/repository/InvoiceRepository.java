package com.capstoneproj.supfinsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproj.supfinsys.models.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    Optional<Invoice> getByUsername(String username);

    Optional<List<Invoice>> findAllByUsername(String username);

    Optional<List<Invoice>> findAllBySupplierCode(Long supplierCode);
}
