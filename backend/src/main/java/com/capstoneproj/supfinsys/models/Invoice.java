package com.capstoneproj.supfinsys.models;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="invoiceData")
public class Invoice {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column(name = "supplierCode", nullable = false)
	private String supplierCode;
	
	@Column(name = "invoiceNumber", nullable = false)
	private String invoiceNumber;

	@Column(name = "invoiceDate", nullable = false)
	private String invoiceDate ;
	
	@Column(name = "invoiceAmount", nullable = false)
	private String invoiceAmount;
	
	@Column(name = "currency", nullable = false)
	private String currency;

	@Column(name = "username")
	private String username;

	@Column(name = "file")
	@Lob
	private byte[] file;

	@Override
	public String toString() {
		return "Invoice [supplierCode=" + supplierCode + ", invoiceNumber=" + invoiceNumber + ", invoiceDate="
				+ invoiceDate + ", invoiceAmmount=" + invoiceAmount + ", currency=" + currency + "]";
	}
	
	

}
