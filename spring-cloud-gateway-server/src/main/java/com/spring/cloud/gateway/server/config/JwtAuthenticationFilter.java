package com.spring.cloud.gateway.server.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JwtAuthenticationFilter implements GlobalFilter {

	private final WebClient webClient;

	public JwtAuthenticationFilter(WebClient webClient) {
		this.webClient = webClient;

	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		// Define the paths to exclude from authentication
		String path = exchange.getRequest().getURI().getPath();
		if (shouldSkipAuthentication(path)) {
			log.info("JwtAuthenticationFilter: Skipping authentication for path: {}", path);
			return chain.filter(exchange); // Skip the filter for excluded paths
		}

		log.info("JwtAuthenticationFilter: Get JWT token from the Request Headers");

		String token = extractJwtFromRequest(exchange.getRequest());

		// Validate the token asynchronously
		return validateToken(token).flatMap(isValid -> {
			if (!isValid) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				return exchange.getResponse().setComplete();
			}
			log.info("JwtAuthenticationFilter: Token is valid, processing the next step");
			return chain.filter(exchange);
		}).onErrorResume(e -> {
			log.error("Error occurred during token validation: {}", e.getMessage());
			exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
			return exchange.getResponse().setComplete();
		});

	}

	private boolean shouldSkipAuthentication(String path) {
		log.info("Define your paths that should be skipped");
		return path.startsWith("/api/v1/authmang/signin") || path.startsWith("/api/v1/authmang/signup")
				|| path.startsWith("/api/v1/authmang/validate-token/");
	}

	private String extractJwtFromRequest(ServerHttpRequest request) {
		String bearerToken = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

	private Mono<Boolean> validateToken(String token) {
		String url = "http://localhost:8071/api/v1/authmang/validate-token/" + token;
		return webClient.get().uri(url).retrieve().bodyToMono(Boolean.class);

	}

}
