package com.capstoneproj.supfinsys.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

public class SupplierDto implements Serializable {
    private final Long id;
    private final Long creditAccNumber;
    private final String supplierName;
    private final String supplierEmail;
    private final int supplierMob;
    private final String supplierAddress;
    private final String creditInfo;
    private final String username;
    private final String password;


    public SupplierDto(Long id, Long creditAccNumber, String supplierName, String supplierEmail, int supplierMob, String supplierAddress, String creditInfo, String username, String password) {
        this.id = id;
        this.creditAccNumber = creditAccNumber;
        this.supplierName = supplierName;
        this.supplierEmail = supplierEmail;
        this.supplierMob = supplierMob;
        this.supplierAddress = supplierAddress;
        this.creditInfo = creditInfo;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public Long getCreditAccNumber() {
        return creditAccNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public int getSupplierMob() {
        return supplierMob;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getCreditInfo() {
        return creditInfo;
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
        SupplierDto entity = (SupplierDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.creditAccNumber, entity.creditAccNumber) &&
                Objects.equals(this.supplierName, entity.supplierName) &&
                Objects.equals(this.supplierEmail, entity.supplierEmail) &&
                Objects.equals(this.supplierMob, entity.supplierMob) &&
                Objects.equals(this.supplierAddress, entity.supplierAddress) &&
                Objects.equals(this.creditInfo, entity.creditInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creditAccNumber, supplierName, supplierEmail, supplierMob, supplierAddress, creditInfo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "creditAccNumber = " + creditAccNumber + ", " +
                "supplierName = " + supplierName + ", " +
                "supplierEmail = " + supplierEmail + ", " +
                "supplierMob = " + supplierMob + ", " +
                "supplierAddress = " + supplierAddress + ", " +
                "creditInfo = " + creditInfo + ")";
    }
}