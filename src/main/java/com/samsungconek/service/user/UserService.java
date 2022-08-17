package com.samsungconek.service.user;

import com.samsungconek.model.entity.User;
import com.samsungconek.model.entity.CustomUserDetails;
import com.samsungconek.repository.IUserRepository;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {
    // implement thêm 1 interface UserDetailsService để sử dụng phương thức loadUserByUsername
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        BusinessAssert.isTrue(userOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return userOptional.get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        BusinessAssert.isTrue(userOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        BusinessAssert.notNull(user, BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
}
