package com.samsungconek.service.user;

import com.samsungconek.model.dto.UserInputDto;
import com.samsungconek.model.entity.User;
import com.samsungconek.model.entity.CustomUserDetails;
import com.samsungconek.repository.IUserRepository;
import com.samsungconek.utils.CustomResponse;
import com.samsungconek.utils.exception.BusinessAssert;
import com.samsungconek.utils.exception.BusinessExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {
    // implement thêm 1 interface UserDetailsService để sử dụng phương thức loadUserByUsername
    @Autowired
    private IUserRepository userRepository;

    @Value("${file-upload}")
    private String uploadPath;

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
    public CustomResponse deleteById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        BusinessAssert.isTrue(userOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        userRepository.deleteById(id);
        return new CustomResponse("Thành công", 1);
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
    public User findByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        BusinessAssert.isTrue(userOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return userOptional.get();
    }

    @Override
    public User update(Long id, UserInputDto userInputDto) {
        Optional<User> userOptional = userRepository.findById(id);
        BusinessAssert.isTrue(userOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        User user = new User();
        user.setId(id);
        user.setEmail(userInputDto.getEmail());
        user.setStatus(userInputDto.getStatus());
        user.setCompany(userInputDto.getCompany());
        user.setRole(userInputDto.getRole());
        user.setAddress1(userInputDto.getAddress1());
        user.setAddress2(userInputDto.getAddress2());
        user.setPhone(userInputDto.getPhone());
        user.setFullName(userInputDto.getFullName());
        MultipartFile img = userInputDto.getAvatar();
        if (img != null && img.getSize() != 0) {
            String fileName = img.getOriginalFilename();
            long currentTime = System.currentTimeMillis();
            fileName = currentTime + "_" + fileName;
            try {
                FileCopyUtils.copy(img.getBytes(), new File(uploadPath + fileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            user.setAvatar(fileName);
        }
        user.setAvatar("avatar.png");
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        BusinessAssert.isTrue(userOptional.isPresent(), BusinessExceptionCode.NOT_EXIST, "Không tồn tại");
        return new CustomUserDetails(userOptional.get());
        }
    }
