package br.com.productsoftware.security.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.productsoftware.infra.domain.Usuario;

@Service
public class TokenService {

	public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("Tickets")
                .withSubject(usuario.getEmail())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusHours(15)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("testeAlgoritmo"));
    }
	
    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("testeAlgoritmo"))
                .withIssuer("Tickets")
                .build().verify(token).getSubject();

    }


}
