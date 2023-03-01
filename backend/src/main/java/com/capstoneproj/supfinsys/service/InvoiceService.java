package com.capstoneproj.supfinsys.service;

import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Invoice;

import java.util.List;

@Service("InvoiceService")
public interface InvoiceService {
	
	Invoice saveInvoice(Invoice invoice);

	List<Invoice> getInvoiceData(String username);

	List<Invoice> getAllInvoiceData();

    List<Invoice> getInvoiceForSupplierCode(Long supplierCode);
}
