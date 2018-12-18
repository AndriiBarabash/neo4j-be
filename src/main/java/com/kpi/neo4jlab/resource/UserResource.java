package com.kpi.neo4jlab.resource;

import com.kpi.neo4jlab.model.Movie;
import com.kpi.neo4jlab.model.User;
import com.kpi.neo4jlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/r")
    public Collection<User> getRecommendationFor(@RequestBody Movie movie) {
        return userService.getRecommendationFor(movie);
    }
}
