package com.example.movie.services;

import com.example.movie.entities.Movie;
import com.example.movie.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <description>
 *
 * @author Ahmed Shakir
 * @version 1.0
 * @since 2020-10-27
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final ConsumerService consumerService;

    public List<Movie> findAll(String title) {
        var movies = movieRepository.findAll();
        movies = movies.stream().filter(movie -> movie.getTitle().contains(title)).collect(Collectors.toList());
        if(movies.isEmpty()) {
            log.info("Searching in OMDB");
            var movieSearch = consumerService.search(title);
            if(movieSearch.isPresent()) {
                var savedMovie = movieRepository.save(movieSearch.get());
                movies.add(savedMovie);
            }
        }
        return movies;
    }
}
