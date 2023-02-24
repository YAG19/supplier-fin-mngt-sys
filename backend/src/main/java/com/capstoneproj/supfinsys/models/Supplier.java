package com.capstoneproj.supfinsys.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@OneToOne(mappedBy = "supplier")
	private User user;

	@Column(name = "creditaccountnumber", nullable = false)
	private Long creditAccNumber;
	
	@Column(name = "suppliername", nullable = false, length = 45)
	private String supplierName;
	
	@Column(name = "supplieremail", nullable = false, length = 45)
	private String supplierEmail;
	
	@Column(name = "suppliermobnumber", length = 10)
	private int supplierMob;
	
	@Column(name = "supplieraddress", length = 200)
	private String supplierAddress;
	
	@Column(name = "creditinfo", length = 145)
	private String creditInfo;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreditAccNumber() {
		return creditAccNumber;
	}

	public void setCreditAccNumber(Long creditAccNumber) {
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
}
