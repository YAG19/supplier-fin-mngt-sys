package com.capstoneproj.supfinsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproj.supfinsys.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
