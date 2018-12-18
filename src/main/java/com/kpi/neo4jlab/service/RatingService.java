package com.kpi.neo4jlab.service;

import com.kpi.neo4jlab.model.Movie;
import com.kpi.neo4jlab.model.Rating;
import com.kpi.neo4jlab.model.User;
import com.kpi.neo4jlab.repository.MovieRepository;
import com.kpi.neo4jlab.repository.RatingRepository;
import com.kpi.neo4jlab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> createRating(Long userId, Long movieId, Long score) {
        Rating rating = new Rating();
        Optional<Movie> startNode = movieRepository.findById(movieId);
        Optional<User> endNode = userRepository.findById(userId);
        if (!startNode.isPresent() || !endNode.isPresent()) {
            throw new RuntimeException("Movie or User is not found!");
        }

        if (ratingRepository.findByMovieAndUser(startNode.get(), endNode.get()) != null) {
            throw new RuntimeException("Duplicate rating found!");
        }

        rating.setMovie(startNode.get());
        rating.setUser(endNode.get());
        rating.setRating(score);
        ratingRepository.save(rating);
        return ResponseEntity.ok().build();
    }
}
