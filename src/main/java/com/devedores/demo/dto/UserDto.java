package com.devedores.demo.dto;

import com.devedores.demo.models.Address;
import com.devedores.demo.models.Geolocation;
import com.devedores.demo.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto implements Serializable {

    private static final long serialVersionUID = -8558701494290136196L;

    private Integer id;
    private String name;
    private String username;
    private String email;
    private BigDecimal lat;
    private BigDecimal lng;
    private String city;
    private String street;
    private String suite;
    private String phone;
    private String zipcode;
    private String website;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public User convertDtoToObject() {
        User user = new User();
        Address address = new Address();
        Geolocation geolocation = new Geolocation();

        BeanUtils.copyProperties(this, user);
        BeanUtils.copyProperties(this, address);
        BeanUtils.copyProperties(this, geolocation);

        address.setGeo(geolocation);
        user.setAddress(address);
        return user;
    }

    public static UserDto convertObjectToDto(User user) {
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(user, userDto);

        if(user.getAddress() != null){
            BeanUtils.copyProperties(user.getAddress(), userDto);
            if(user.getAddress().getGeo() != null){
                BeanUtils.copyProperties(user.getAddress().getGeo(), userDto);
            }
        }

        return userDto;
    }
}
