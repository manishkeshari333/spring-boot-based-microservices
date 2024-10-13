package com.spring.cloud.auth.management.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;

    @Value("${spring.app.jwtExpirationsMs}")
    private int jwtExpirationsMs;

    public String getJwtFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        log.info("Authorization Header: {}", bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String generateTokenFromUsername(UserDetails userDetails) {
        String username = userDetails.getUsername();
        return Jwts.builder().subject(username).issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpirationsMs))
                .signWith(Key())
                .compact();
    }

    public String getUsernameFromToken(String Token) {
        return Jwts.parser()
                .verifyWith((SecretKey) Key()).build()
                .parseSignedClaims(Token).getPayload()
                .getSubject();
    }

    private Key Key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().verifyWith((SecretKey) Key()).build().parseSignedClaims(authToken);
            return true;
        } catch (MalformedJwtException exception) {
            log.error("Invalid JWT Token: {}", exception);

        } catch (ExpiredJwtException exception) {
            log.error("JWT Token is Expired: {}", exception);

        } catch (UnsupportedJwtException exception) {
            log.error("JWT Token is Unsupported: {}", exception);

        } catch (IllegalArgumentException exception) {
            log.error("JWT claims String is Empty: {}", exception);

        }
        return false;
    }

}

