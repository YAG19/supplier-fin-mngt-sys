package com.capstoneproj.supfinsys.models;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
	private Long supplierCode;
	
	@Column(name = "invoiceNumber", nullable = false)
	private Long invoiceNumber;

	@Column(name = "invoiceDate", nullable = false)
	private Date invoiceDate ;
	
	@Column(name = "invoiceAmount", nullable = false)
	private Double invoiceAmount;
	
	@Column(name = "currency", nullable = false)
	private String currency;

	@Column(name = "username")
	private String username;

	@Column(name = "invoiceStatus")
	private String invoiceStatus;

	@Column(name = "file")
	@Lob
	private byte[] file;

	@Override
	public String toString() {
		return "Invoice [supplierCode=" + supplierCode + ", invoiceNumber=" + invoiceNumber + ", invoiceDate="
				+ invoiceDate + ", invoiceAmmount=" + invoiceAmount + ", currency=" + currency + "]";
	}
	
	

}
