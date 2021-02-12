package com.example.movie.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.entities.Movie;
import com.example.movie.services.MovieService;

import lombok.RequiredArgsConstructor;

/**
 * Movie API
 * <p>
 * Currently movie search is the only feature and is accessible trough the endpoint /api/v1/movies
 *
 * @author Ahmed Shakir
 * @version 1.0
 * @since 2020-10-27
 */
@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies(@RequestParam(required = false) String title) {
        var isTitleAvailableString = "Title is available: " + !(title == null || title.isEmpty());
        var titleString = "Title: " + (title != null ? title : "N/A");
        var codeString = "Code: " + (title != null ? title.substring(0, 1).toUpperCase() + "123" : "1234");

        System.out.println(isTitleAvailableString);
        System.out.println(titleString + " " + codeString);

        return ResponseEntity.ok(movieService.findAll(title));
    }
}
