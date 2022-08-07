package com.mycompany.spring_mvc_project_final.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Customer implements Serializable {

    @Column(nullable = false, length = 50)
    private String customerName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false)
    private String gender;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    

}
