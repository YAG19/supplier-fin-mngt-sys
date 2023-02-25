package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Invoice;
import com.capstoneproj.supfinsys.repository.InvoiceRepository;
import com.capstoneproj.supfinsys.service.InvoiceService;

@Service("InvoiceServiceImp")
public class InvoiceServiceImp implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	UserService userService;

	private static RuntimeException getUsernameNotFoundException() {
		throw new UsernameNotFoundException("Username Does Not Found!!");
	}

	@Override
	public Invoice uploadInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

    @Override
    public Invoice getInvoiceData(String username) {
		return invoiceRepository.findByUsername(username).orElseThrow(InvoiceServiceImp::getUsernameNotFoundException);

	}

}
