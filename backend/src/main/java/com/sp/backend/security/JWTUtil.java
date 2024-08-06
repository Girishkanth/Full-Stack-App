// package com.sp.backend.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JWTUtil {

//     @Value("${jwt.secret}")
//     private String secret;

//     @Value("${jwt.expiration}")
//     private long expiration;

//     public String generateToken(String username) {
//         return Jwts.builder()
//             .setSubject(username)
//             .setIssuedAt(new Date())
//             .setExpiration(new Date(System.currentTimeMillis() + expiration))
//             .signWith(SignatureAlgorithm.HS512, secret)
//             .compact();
//     }

//     public Claims getClaims(String token) {
//         return Jwts.parser()
//             .setSigningKey(secret)
//             .parseClaimsJws(token)
//             .getBody();
//     }

//     public String getUsername(String token) {
//         return getClaims(token).getSubject();
//     }

//     public boolean isTokenExpired(String token) {
//         return getClaims(token).getExpiration().before(new Date());
//     }

//     public boolean validateToken(String token, String username) {
//         return username.equals(getUsername(token)) && !isTokenExpired(token);
//     }
// }
