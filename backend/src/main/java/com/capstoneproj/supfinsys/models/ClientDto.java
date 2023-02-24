package com.capstoneproj.supfinsys.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Client} entity
 */
public class ClientDto implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final String mobileNumber;
    private final String address;
    private final String loanInfo;
    private final Long loanAccNumber;
    private final String username;
    private final String password;

    public ClientDto(Long id, String name, String email, String mobileNumber, String address, String loanInfo, Long loanAccNumber, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.loanInfo = loanInfo;
        this.loanAccNumber = loanAccNumber;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getLoanInfo() {
        return loanInfo;
    }

    public Long getLoanAccNumber() {
        return loanAccNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto entity = (ClientDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.mobileNumber, entity.mobileNumber) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.loanInfo, entity.loanInfo) &&
                Objects.equals(this.loanAccNumber, entity.loanAccNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, mobileNumber, address, loanInfo, loanAccNumber);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "mobileNumber = " + mobileNumber + ", " +
                "address = " + address + ", " +
                "loanInfo = " + loanInfo + ", " +
                "loanAccNumber = " + loanAccNumber + ")";
    }
}