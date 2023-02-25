package com.capstoneproj.supfinsys.controller;

import com.capstoneproj.supfinsys.exception.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@Qualifier("InvoiceService")
	private InvoiceService invoiceService;

	@PostMapping(path = "/upload")
	public ResponseEntity<ResponseMessage> invoiceUpload(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("invoice") String invoiceJson ) throws IOException {
		Invoice invoice = convertToDto(invoiceJson);
		if(file == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Please Upload A File"));
		if(file.getSize() > 1000000) return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body( new ResponseMessage("FILE SIZE IS GREATER THAN 1 MB"));
		invoice.setFile(file.getBytes());
		invoiceService.uploadInvoice(invoice);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Successfully Uploaded"));
	}

	@GetMapping("/view")
	public void getInvoiceData(String username){
		this.invoiceService.getInvoiceData(username);
	}

	private Invoice convertToDto(String invoiceJson) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(invoiceJson, Invoice.class) ;

	}
}
