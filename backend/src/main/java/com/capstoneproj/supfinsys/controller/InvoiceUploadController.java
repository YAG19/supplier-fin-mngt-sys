package com.capstoneproj.supfinsys.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.capstoneproj.supfinsys.models.Invoice;
import com.capstoneproj.supfinsys.service.InvoiceService;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoiceUploadController {

	@Autowired
	InvoiceService invoiceService;

	@PostMapping(path = "/upload")
	public Invoice invoiceUpload(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("invoice") String invoiceJson ) throws IOException {
		Invoice invoice = convertToDto(invoiceJson);
		invoice.setFile(file.getBytes());
		return invoiceService.uploadInvoice(invoice);
	}

	private Invoice convertToDto(String invoiceJson) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(invoiceJson, Invoice.class) ;

	}
}
