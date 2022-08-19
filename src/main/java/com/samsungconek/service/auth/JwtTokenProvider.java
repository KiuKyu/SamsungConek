package com.samsungconek.service.auth;

import com.samsungconek.model.entity.CustomUserDetails;
import com.samsungconek.utils.exception.CustomException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private final String JWT_SECRET = "SamsungConnecto";
    private final long JWT_EXPIRATION = 604800000L;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

    public String generateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        Date expDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder()
                .setSubject(Long.toString(userDetails.getUser().getId()))
                .setIssuedAt(now)
                .setExpiration(expDate)
                .signWith(SignatureAlgorithm.ES512, JWT_SECRET)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) throws CustomException {
        try {
            Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            throw new CustomException(400, "JWT token đã hết hạn");
        } catch (UnsupportedJwtException e) {
            throw new CustomException(400, "JWT token không hỗ trợ");
        } catch (MalformedJwtException e) {
            throw new CustomException(400, "JWT không hợp lệ");
        } catch (SignatureException e) {
            throw new CustomException(400, "Chữ ký không hợp lệ");
        } catch (IllegalArgumentException e) {
            throw new CustomException(400, "JWT claims rỗng");
        }
    }
}
