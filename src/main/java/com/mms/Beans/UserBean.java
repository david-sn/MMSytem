package com.mms.Beans;

import java.io.Serializable;

import com.mms.Hibernate.Entity.User;
import com.mms.Service.UserServiceImpl;

public class UserBean implements Serializable {

    UserServiceImpl userService;

    private String name;
    private String surname;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void persistUser() {
        User user = new User();
        user.setName(getName());
        user.setSurname(getSurname());
        userService.persistUser(user);
    }

}
