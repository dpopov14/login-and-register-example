package com.example.backend.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtService {
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
}
