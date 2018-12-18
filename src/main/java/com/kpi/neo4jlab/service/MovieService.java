package com.kpi.neo4jlab.service;

import com.kpi.neo4jlab.model.Movie;
import com.kpi.neo4jlab.model.User;
import com.kpi.neo4jlab.repository.MovieRepository;
import com.kpi.neo4jlab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    public Collection<Movie> getAll() {
        return movieRepository.getAllMovies();
    }

    public ResponseEntity<Object> createMovie(Movie movie) {
        if (movie.getDirector().isEmpty() || movie.getTitle().isEmpty()) {
            throw new RuntimeException("Title or Director is not set!");
        }

        if (movieRepository.findByTitleAndDirector(movie.getTitle(), movie.getDirector()) != null) {
            throw new RuntimeException("Duplicate movie!");
        }
        movieRepository.save(movie);
        return ResponseEntity.ok().build();
    }

    public Collection<Movie> getRecommendationFor(User user) {
        User persistedUser = userRepository.findById(user.getId()).orElse(new User());
        return movieRepository.getRecommendationFor(persistedUser);
    }
}
