package com.capstoneproj.supfinsys.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="invoiceData")
public class Invoice {
	
	@Id
	@Column(name = "supplierCode", nullable = false)
	private Integer supplierCode;
	
	@Column(name = "invoiceNumber", nullable = false)
	private Integer invoiceNumber;
	
	@Column(name = "invoiceDate", nullable = false)
	private  String invoiceDate ;
	
	@Column(name = "invoiceAmount", nullable = false)
	private Integer invoiceAmount;
	
	@Column(name = "currency", nullable = false)
	private String currency;
	
	@Column(name = "file")
	@Lob
	private byte[] file;

	public Integer getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(Integer supplierCode) {
		this.supplierCode = supplierCode;
	}

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Integer getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Integer invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Invoice [supplierCode=" + supplierCode + ", invoiceNumber=" + invoiceNumber + ", invoiceDate="
				+ invoiceDate + ", invoiceAmmount=" + invoiceAmount + ", currency=" + currency + "]";
	}
	
	

}
