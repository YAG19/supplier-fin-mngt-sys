package com.capstoneproj.supfinsys.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplierinfo")
public class Supplier {
	@Id
	@Column(name = "creditaccountnumber", nullable = false)
	private int creditAccNumber;
	
	@Column(name = "suppliername", nullable = false, length = 45)
	private String supplierName;
	
	@Column(name = "supplieremail", nullable = false, length = 45)
	private String supplierEmail;
	
	@Column(name = "suppliermobnumber", length = 10)
	private int supplierMob;
	
	@Column(name = "supplieraddress", length = 60)
	private String supplierAddress;
	
	@Column(name = "creditinfo", length = 45)
	private String creditInfo;

	public int getCreditAccNumber() {
		return creditAccNumber;
	}

	public void setCreditAccNumber(int creditAccNumber) {
		this.creditAccNumber = creditAccNumber;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	public int getSupplierMob() {
		return supplierMob;
	}

	public void setSupplierMob(int supplierMob) {
		this.supplierMob = supplierMob;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getCreditInfo() {
		return creditInfo;
	}

	public void setCreditInfo(String creditInfo) {
		this.creditInfo = creditInfo;
	}

	@Override
	public String toString() {
		return "Supplier [creditAccNumber=" + creditAccNumber + ", supplierName=" + supplierName + ", supplierEmail="
				+ supplierEmail + ", supplierMob=" + supplierMob + ", supplierAddress=" + supplierAddress
				+ ", creditInfo=" + creditInfo + "]";
	}
}
