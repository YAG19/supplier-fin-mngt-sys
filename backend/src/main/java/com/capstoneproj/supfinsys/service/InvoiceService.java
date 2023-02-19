package com.capstoneproj.supfinsys.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capstoneproj.supfinsys.models.Invoice;

@Service("InvoiceService")
public interface InvoiceService {
	
	Invoice uploadInvoice(Invoice invoice);
	//public Invoice store(MultipartFile file);

}
