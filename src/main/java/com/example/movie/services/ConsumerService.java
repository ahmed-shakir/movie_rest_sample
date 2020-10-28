package com.example.movie.services;

import com.example.movie.entities.Movie;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * <description>
 *
 * @author Ahmed Shakir
 * @version 1.0
 * @since 2020-10-27
 */
@Service
@ConfigurationProperties(value = "example.movie", ignoreUnknownFields = false)
public class ConsumerService {
    private RestTemplate restTemplate;
    private String baseUrl;

    public ConsumerService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Optional<Movie> search(String title) {
        var url = baseUrl + "&t=" + title;
        return Optional.ofNullable(restTemplate.getForObject(url, Movie.class));
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
