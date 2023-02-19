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
	
	@Column(name = "invoiceAmmount", nullable = false)
	private Integer invoiceAmmount;
	
	@Column(name = "currency", nullable = false)
	private String currency;

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

	public Integer getInvoiceAmmount() {
		return invoiceAmmount;
	}

	public void setInvoiceAmmount(Integer invoiceAmmount) {
		this.invoiceAmmount = invoiceAmmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Override
	public String toString() {
		return "Invoice [supplierCode=" + supplierCode + ", invoiceNumber=" + invoiceNumber + ", invoiceDate="
				+ invoiceDate + ", invoiceAmmount=" + invoiceAmmount + ", currency=" + currency + "]";
	}
	
	

}
