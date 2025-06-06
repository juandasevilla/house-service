package com.example.houseservice.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {
    @Value("${api.key.header:X-API-KEY}")
    private String apiKeyHeader;

    @Value("${api.key.value}")
    private String apiKeyValue;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String requestPath = request.getRequestURI();

        // Solo aplicar este filtro al endpoint específico
        if (requestPath.matches("/api/v1/real-state/exists-real-state/\\d+")) {
            String apiKey = request.getHeader(apiKeyHeader);

            if (apiKey == null || !apiKey.equals(apiKeyValue)) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
