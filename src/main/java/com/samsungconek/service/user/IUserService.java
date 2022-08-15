package com.samsungconek.service.user;

import com.samsungconek.model.entity.User;
import com.samsungconek.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    Page<User> findAll(Pageable pageable);

    User findByUsername(String username);

    Optional<User> findByEmail(String email);
}
