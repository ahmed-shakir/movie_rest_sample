package com.example.movie.repositories;

import com.example.movie.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ahmed Shakir
 * @version 1.0
 * @since 2020-10-27
 */
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
}
