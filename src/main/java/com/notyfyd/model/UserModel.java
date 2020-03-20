package com.notyfyd.model;

import com.notyfyd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserModel {
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private List<RoleModel> roles;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<RoleModel> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }
}
