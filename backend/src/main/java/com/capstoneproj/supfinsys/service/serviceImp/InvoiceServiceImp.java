package com.capstoneproj.supfinsys.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capstoneproj.supfinsys.models.Invoice;
import com.capstoneproj.supfinsys.repository.InvoiceRepository;
import com.capstoneproj.supfinsys.service.InvoiceService;

@Service
public class InvoiceServiceImp implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;

	@Override
	public Invoice uploadInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

}
