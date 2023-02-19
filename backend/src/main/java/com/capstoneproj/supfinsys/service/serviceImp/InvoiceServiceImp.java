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
		// TODO Auto-generated method stub
		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice store(MultipartFile file) {
		// TODO Auto-generated method stub
		Invoice invoice=new Invoice();
		return invoiceRepository.save(invoice);
	}

}
