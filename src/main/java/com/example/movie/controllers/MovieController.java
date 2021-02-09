package com.example.movie.controllers;

import com.example.movie.entities.Movie;
import com.example.movie.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <description>
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
        return ResponseEntity.ok(movieService.findAll(title));
    }
}