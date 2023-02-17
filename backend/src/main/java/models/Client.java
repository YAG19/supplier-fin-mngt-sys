//package models;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Client")
//public class Client {
//
//    @Id
//    @Column(name = "LoanAccNumber", nullable = false)
//    private Integer id;
//
//    @Column(name = "Name", nullable = false, length = 45)
//    private String name;
//
//    @Column(name = "Email", nullable = false, length = 45)
//    private String email;
//
//    @Column(name = "MobileNumber", length = 10)
//    private String mobileNumber;
//
//    @Column(name = "Address", length = 60)
//    private String address;
//
//    @Column(name = "LonaInfo", length = 45)
//    private String lonaInfo;
//
//    public String getLonaInfo() {
//        return lonaInfo;
//    }
//
//    public void setLonaInfo(String lonaInfo) {
//        this.lonaInfo = lonaInfo;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//}
