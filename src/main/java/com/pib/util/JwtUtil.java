package com.pib.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pib.property.entity.Account;
import com.pib.property.exception.UnauthorizationException;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

public class JwtUtil {
    public static String generate(Account e) {
        Date expiresAt = Date.from(LocalDateTime.now().plusMinutes(10).toInstant(OffsetDateTime.now().getOffset()));
        String token = JWT.create()
                .withClaim("id", e.getId())
                .withClaim("username", e.getUsername())
                .withClaim("type",e.getType())
                .withExpiresAt(expiresAt).sign(Algorithm.HMAC256("secret"));
        return token;
    }

    public static Account decode(String token) throws UnauthorizationException {
        try {
            DecodedJWT jwt = JWT.require(Algorithm.HMAC256("secret")).build().verify(token);
            return new Account.Builder()
                    .set("id", jwt.getClaim("id").asLong())
                    .set("username",jwt.getClaim("username").asString())
                    .set("type", jwt.getClaim("type").asString())
                    .build();
        } catch (Exception ex) {
            throw new UnauthorizationException("unauth");
        }
    }


}
