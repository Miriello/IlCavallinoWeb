package com.example.ilcavallinobackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private final String chiave;
    private final long jwtExpirationMs;

    public JwtService(
            @Value("${application.security.jwt.secret-key}") String chiave,
            @Value("${application.security.jwt.expiration-ms}") long jwtExpirationMs) {
        this.chiave=chiave;
        this.jwtExpirationMs=jwtExpirationMs;
    }

    public String estraiUsername(String token){
        return estraiClaim(token, Claims::getSubject);
    }

    public <T> T estraiClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = estaiTutti(token);
        return claimsResolver.apply(claims);
    }

    private Claims estaiTutti(String token){
        return Jwts.parser()
                .verifyWith(getFirma())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generaToken(UserDetails userDetails){
        return generaToken(new HashMap<>(), userDetails);
    }

    public String generaToken(Map<String, Object> extraClaims, UserDetails userDetails){
        long adesso = System.currentTimeMillis();
        return Jwts.builder()
                .claims(extraClaims) //CLAIM AGGIUNTI DA NOI
                .subject(userDetails.getUsername())
                .issuedAt(new Date(adesso))
                .expiration(new Date(adesso + jwtExpirationMs))
                .signWith(getFirma())
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username= estraiUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        Date scadenza = estraiClaim(token, Claims::getExpiration);
        return scadenza.before(new Date());
    }

    private SecretKey getFirma () {
        byte[] keyBytes = Decoders.BASE64.decode(chiave);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
