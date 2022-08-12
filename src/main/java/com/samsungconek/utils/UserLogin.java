package com.samsungconek.utils;

import com.samsungconek.constant.ActiveStatus;
import com.samsungconek.model.entity.Role;
import com.samsungconek.model.entity.User;
import lombok.Data;

@Data
public class UserLogin {
    private Long id;
    private String username;
    private Role role;
    private String email;
    private ActiveStatus status;
    private String phone;
    private String company;
    private String address1;
    private String address2;
    private String fullName;

    public UserLogin() {
    }

    public UserLogin(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role = user.getRole();
        this.status = user.getStatus();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.company = user.getCompany();
        this.address1 = user.getAddress1();
        this.address2 = user.getAddress2();
        this.fullName = user.getFullName();
    }

    public UserLogin(Role role, Long id, String username) {
        super();

        this.role = role;
        this.id = id;
        this.username = username;
    }

    public boolean isRole(String... roles) {
        if (this.role != null && roles != null) {
            for (String role : roles) {
                if (this.role.getName().equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }
}
