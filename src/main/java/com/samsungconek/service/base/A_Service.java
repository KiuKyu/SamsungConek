package com.samsungconek.service.base;

import com.samsungconek.constant.UserRole;
import com.samsungconek.model.dto.base.PageNumberRequestDto;
import com.samsungconek.model.entity.User;
import com.samsungconek.repository.IUserRepository;
import com.samsungconek.utils.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;

public class A_Service {
    @Autowired
    private IUserRepository userRepository;

    private static final int PAGE_SIZE_DEFAULT = 20;

    protected Pageable getPageRequest(PageNumberRequestDto pageNumberRequestDto) {
        int pageSize = pageNumberRequestDto == null || pageNumberRequestDto.getPageSize() == null ? PAGE_SIZE_DEFAULT : pageNumberRequestDto.getPageSize();
        int pageNumber = pageNumberRequestDto == null || pageNumberRequestDto.getPageNumber() == null ? 0 : pageNumberRequestDto.getPageNumber() -1;
        return PageRequest.of(pageNumber, pageSize);
    }

    public String getUsernameLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public UserLogin getUserLogin() {
        String username = getUsernameLogin();
        User user = userRepository.findByUsername(username);
        if (user != null && user.getRole() != null) {
            return new UserLogin(user);
        }
        return null;
    }

    protected boolean isAdmin() {
        UserLogin userLogin = getUserLogin();
        return userLogin.isRole(UserRole.ROLE_ADMIN.name());
    }

    protected boolean isSupport() {
        UserLogin userLogin = getUserLogin();
        return userLogin.isRole(UserRole.ROLE_SUPPORT.name());
    }

    protected boolean isCustomer() {
        UserLogin userLogin = getUserLogin();
        return userLogin.isRole(UserRole.ROLE_CUSTOMER.name());
    }
}
