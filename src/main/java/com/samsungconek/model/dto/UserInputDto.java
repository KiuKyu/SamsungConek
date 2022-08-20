package com.samsungconek.model.dto;

import com.samsungconek.constant.ActiveStatus;
import com.samsungconek.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputDto {
    private Long id;

    private String fullName;

    private String username;

    private String password;

    private MultipartFile avatar;

    private ActiveStatus status;

    private String email;

    private String company;

    private String address1;

    private String address2;

    private Role role;

    private String phone;
}
