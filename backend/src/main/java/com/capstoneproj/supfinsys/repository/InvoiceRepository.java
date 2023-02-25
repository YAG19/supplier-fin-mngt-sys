package com.capstoneproj.supfinsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproj.supfinsys.models.Invoice;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    Optional<Invoice> getByUsername(String username);

    @Override
    default Optional<Invoice> findById(Integer integer) {
        return Optional.empty();
    }

    Optional<Invoice> findByUsername(String username);
}
