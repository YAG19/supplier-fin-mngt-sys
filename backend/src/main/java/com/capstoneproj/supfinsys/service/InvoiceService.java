package com.capstoneproj.supfinsys.service;

import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Invoice;

@Service("InvoiceService")
public interface InvoiceService {
	
	Invoice uploadInvoice(Invoice invoice);

	Invoice getInvoiceData(String username);

}
