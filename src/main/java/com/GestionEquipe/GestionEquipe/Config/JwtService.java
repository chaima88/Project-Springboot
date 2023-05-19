package com.GestionEquipe.GestionEquipe.Config;

import com.GestionEquipe.GestionEquipe.model.MembreEquipe;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "34753778214125442A462D4A614E645267556B58703273357638792F423F4528";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails, Utilisateur user) {
        return generateToken(new HashMap<>(), userDetails,user);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            Utilisateur user
    ) {
        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        try {
            if(user.getRole()!=null) {
                claims.put("role", user.getRole().name());
            }
        }catch (Exception e){

        }

        claims.put("id",user.getId());
//        try {
//            if( ((MembreEquipe) user).getEquipe()!=null && ((MembreEquipe) user).getEquipe().getDiscussion()!=null) {
//                claims.put("discussion", ((MembreEquipe) user).getEquipe().getDiscussion().getIdDicuss());
//            }
//        }catch (Exception e){
//
//        }

        return Jwts
                .builder()
                .setClaims(claims)
                //.setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}