package com.linkora.apigateway.Filters;

import com.linkora.apigateway.Service.AuthService;
import io.jsonwebtoken.JwtException;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    private final AuthService authService;

    public AuthenticationFilter(AuthService authService){
        super(Config.class);
        this.authService = authService;
    }

    @Override
    public GatewayFilter apply(Config config) {

            return ((exchange, chain) -> {
                final String header = exchange.getRequest().getHeaders().getFirst("Authorization");
                if(header == null || !header.startsWith("Bearer")){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

                final String token = header.split("Bearer ")[1];

                try {
                    String userId = authService.getUserIdFromToken(token);
                    ServerWebExchange modifiedExchange = exchange
                            .mutate()
                            .request(r -> r.header("X-User-Id", userId))
                            .build();

                    return chain.filter(modifiedExchange);
                } catch (JwtException e) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }

            });

    }

    public static class Config{

    }
}
