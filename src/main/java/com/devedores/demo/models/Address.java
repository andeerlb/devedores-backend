package com.devedores.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {
    @Column(name = "street")
    private String street;
    @Column(name = "suite")
    private String suite;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipcode;

    @Embedded
    private Geolocation geo;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Geolocation getGeo() {
        return geo;
    }

    public void setGeo(Geolocation geo) {
        this.geo = geo;
    }
}
