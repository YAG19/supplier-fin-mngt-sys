package com.capstoneproj.supfinsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capstoneproj.supfinsys.models.Invoice;
import com.capstoneproj.supfinsys.service.InvoiceService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceUploadCcontroller {

	@Autowired
	InvoiceService invoiceService;

	@PostMapping("/upload")
	public Invoice invoiceUpload(@ModelAttribute Invoice invoice, @RequestParam("file") MultipartFile file) {
		invoiceService.uploadInvoice(invoice);
		return invoiceService.store(file);

	}

}
