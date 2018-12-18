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
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

    public Collection<User> getRecommendationFor(Movie movie) {
        return userRepository.getRecommendationFor(movie);
    }

    public ResponseEntity<Object> createUser(User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
