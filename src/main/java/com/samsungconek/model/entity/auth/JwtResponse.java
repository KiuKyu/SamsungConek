package com.samsungconek.model.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private GrantedAuthority role;

    public JwtResponse(Long id, String token, String username, GrantedAuthority role) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.role = role;
    }
}
