package com.samsungconek.config.security;

import com.samsungconek.model.entity.Role;
import com.samsungconek.utils.UserLogin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHelper {
    public static UserLogin getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UserAuthenticationToken) {
            return extractUserLogin((UserAuthenticationToken) authentication);
        }
        return null;
    }

    public static Long getCurrentUserId() {
        return SecurityContextHelper.getCurrentUser().getId();
    }

    public static boolean isUserHasRole(Role role) {
        UserLogin userLogin = getCurrentUser();
        if (userLogin == null) {
            return false;
        }
        return (userLogin.getRole() == null ? role == null : userLogin.getRole().equals(role));
    }

    public static UserLogin extractUserLogin(UserAuthenticationToken auth) {
        if (auth == null) {
            return null;
        }
        return auth.getUserLogin();
    }

//    check if user is already logged in
    public static boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication instanceof UserAuthenticationToken;
    }
}
