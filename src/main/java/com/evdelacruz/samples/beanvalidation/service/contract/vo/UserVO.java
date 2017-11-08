package com.evdelacruz.samples.beanvalidation.service.contract.vo;

import com.evdelacruz.samples.beanvalidation.service.contract.validation.constraints.UniqueUsername;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserVO implements Serializable {
    private static final long serialVersionUID = -7602891828619297953L;
    private ProfileVO profile;
    private String username;
    private String password;
    private boolean enabled;

    public UserVO() {}

    //<editor-fold desc="Encapsulation">
    @NotNull
    @Valid
    public ProfileVO getProfile() {
        return profile;
    }

    public void setProfile(ProfileVO profile) {
        this.profile = profile;
    }

    @NotNull
    @UniqueUsername
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Size(min=8, max=100)
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
