package com.devedores.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Company {
    @Column(name = "company_name")
    private String name;
    @Column(name = "catch_phrase")
    private String catchPhrase;
    @Column(name = "bs")
    private String bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
