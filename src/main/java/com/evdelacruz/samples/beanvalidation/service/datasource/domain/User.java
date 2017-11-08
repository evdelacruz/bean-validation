package com.evdelacruz.samples.beanvalidation.service.datasource.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -1409482590620487826L;
    private int id;
    private Profile profile;
    private String username;
    private String password;
    private boolean enabled;

    public User() {}

    //<editor-fold desc="Encapsulation">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    //</editor-fold>
}
