package com.devedores.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "website")
    private String website;
    @Column(name = "phone")
    private String phone;

    @Embedded
    private Address address;

    @Embedded
    private Company company;

    public User() {
    }

    public User(Integer id){
        super.setId(id);
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
