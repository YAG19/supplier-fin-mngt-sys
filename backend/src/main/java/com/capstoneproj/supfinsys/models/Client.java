package com.capstoneproj.supfinsys.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "client")
    private User user;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobileNumber", length = 12)
    private String mobileNumber;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "loanInfo")
    private String loanInfo;

//    @Column(name = "username", length = 20 )
//    private String username;

    @Column(name = "loanAccNumber", nullable = false)
    private Long loanAccNumber;

//    @Column(name = "password", length = 40 )
//    private String password;

//    @Column(name = "role")
//    private String role;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(String loanInfo) {
        this.loanInfo = loanInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getLoanAccNumber() {
        return loanAccNumber;
    }

    public void setLoanAccNumber(Long loanAccNumber) {
        this.loanAccNumber = loanAccNumber;
    }


}
