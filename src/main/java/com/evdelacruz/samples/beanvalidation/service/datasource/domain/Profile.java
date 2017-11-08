package com.evdelacruz.samples.beanvalidation.service.datasource.domain;

import java.io.Serializable;

public class Profile implements Serializable {
    private static final long serialVersionUID = 1732469162226123627L;
    private String givenNames;
    private String surNames;
    private String email;
    private int age;

    public Profile() {}

    //<editor-fold desc="Encapsulation">
    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    public String getSurNames() {
        return surNames;
    }

    public void setSurNames(String surNames) {
        this.surNames = surNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //</editor-fold>
}
