package com.capstoneproj.supfinsys.models;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoanAccNumber", nullable = false)
    private Integer loanAccNumber;

    @Column(name = "Name", nullable = false, length = 45)
    private String name;

    @Column(name = "Email", nullable = false, length = 45)
    private String email;

    @Column(name = "MobileNumber", length = 10)
    private String mobileNumber;

    @Column(name = "Address", length = 60)
    private String address;

    @Column(name = "LoanInfo", length = 45)
    private String loanInfo;

    public String getLonaInfo() {
        return loanInfo;
    }

    public void setLonaInfo(String lonaInfo) {
        this.loanInfo = lonaInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLoanAccNumber() {
        return loanAccNumber;
    }

    public void setLoanAccNumber(Integer loanAccNumber) {
        this.loanAccNumber = loanAccNumber;
    }


}
