package com.transportdataexchange.bogdan.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

@Service
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Store a single key for signing and parsing

    // Extract username from the token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract expiration date from the token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Generic method to extract a specific claim from the token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key) // Use the single securely generated key
                .parseClaimsJws(token)
                .getBody();
    }

    // Check if the token is expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Generate a JWT token with the given username and roles
    public String generateToken(String username, Set<String> roles) {
        // Create claims for the token payload
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles); // Embed the roles in the token

        // Generate the token using the claims and username
        return createToken(claims, username, key);
    }

    // Create the token with claims, username, and secure key
    private String createToken(Map<String, Object> claims, String username, Key key) {
        // Define the expiration time of the token (e.g., 1 hour)
        long expirationTime = 1000 * 60 * 60;  // 1 hour

        return Jwts.builder()
                .setClaims(claims)          // Add the claims (including roles)
                .setSubject(username)       // Set the username as the subject
                .setIssuedAt(new Date())    // Set the issued date to current time
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))  // Set the expiration time
                .signWith(key, SignatureAlgorithm.HS256) // Sign with the securely generated key
                .compact(); // Create the JWT token
    }

    // Validate the token by checking the username and expiration
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
