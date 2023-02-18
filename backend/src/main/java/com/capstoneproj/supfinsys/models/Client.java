package com.capstoneproj.supfinsys.models;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loanAccNumber", nullable = false)
    private Integer loanAccNumber;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "mobileNumber", length = 10)
    private String mobileNumber;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "loanInfo", length = 45)
    private String loanInfo;

    @Column(name = "username", length = 20 )
    private String username;

    @Column(name = "password", length = 40 )
    private String password;

    public String getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(String loanInfo) {
        this.loanInfo = loanInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
