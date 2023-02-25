package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Invoice;
import com.capstoneproj.supfinsys.repository.InvoiceRepository;
import com.capstoneproj.supfinsys.service.InvoiceService;

@Service
public class InvoiceServiceImp implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	UserService userService;

	@Override
	public Invoice uploadInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

    @Override
    public void getInvoiceData(String username) {
        invoiceRepository.getReferenceById();
	}

}
