package com.devedores.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Geolocation {
    @Column(name = "latitude")
    private BigDecimal lat;
    @Column(name = "longitude")
    private BigDecimal lng;

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
}
