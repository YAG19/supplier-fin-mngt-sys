package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproj.supfinsys.models.Invoice;
import com.capstoneproj.supfinsys.repository.InvoiceRepository;
import com.capstoneproj.supfinsys.service.InvoiceService;

import java.util.List;

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
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

    @Override
    public List<Invoice> getInvoiceData(String username) {
		List<Invoice> invoiceList = invoiceRepository.findAllByUsername(username).orElseThrow(InvoiceServiceImp::getUsernameNotFoundException);
		return invoiceList;
	}

    @Override
    public List<Invoice> getAllInvoiceData() {
		return invoiceRepository.findAll();
    }

}
