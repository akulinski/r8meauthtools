package com.r8me.authtools.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Slf4j
public class AuthToolsService {

    @Value("${authtools.authServiceUrl}")
    private String url;

    private final RestTemplate restTemplate;

    public AuthToolsService(@Qualifier("authtoolsRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TokenCheckResponseDTO validateToken(TokenDTO tokenDTO) {

        HttpEntity<TokenDTO> httpEntity = new HttpEntity<>(tokenDTO);

        ResponseEntity<TokenCheckResponseDTO> response = restTemplate.exchange(URI.create(url + "/validate"), HttpMethod.POST, httpEntity, TokenCheckResponseDTO.class);
        log.error(response.toString());

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else if (response.getStatusCode() == HttpStatus.FORBIDDEN && response.getBody() != null) {
            throw new IllegalStateException(response.getBody().getReason());
        }

        throw new IllegalStateException("Unknown error, http status: "+response.getStatusCodeValue());
    }
}
