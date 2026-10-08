package com.example.ilcavallinobackend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String chiave;
    private long jwtScadenzaMs;

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
                .expiration(new Date(adesso + jwtScadenzaMs))
                .signWith(getFirma())
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username= estraiUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        Date scadenza = estraiClaim(token, Claims::getExpiration);
        return estraiClaim(token, Claims::getExpiration).before(new Date());
    }

    private SecretKey getFirma () {
        byte[] keyBytes = Decoders.BASE64.decode(chiave);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
