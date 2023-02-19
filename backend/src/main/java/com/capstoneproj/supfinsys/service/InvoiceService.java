package com.capstoneproj.supfinsys.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capstoneproj.supfinsys.models.Invoice;

@Service("InvoiceService")
public interface InvoiceService {
	public Invoice store(MultipartFile file);
	Invoice uploadInvoice(Invoice invoice);

}
