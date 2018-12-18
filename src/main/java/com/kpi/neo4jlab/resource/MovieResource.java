package com.kpi.neo4jlab.resource;

import com.kpi.neo4jlab.model.Movie;
import com.kpi.neo4jlab.model.User;
import com.kpi.neo4jlab.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api/movie")
public class MovieResource {

    @Autowired
    MovieService movieService;

    @GetMapping
    public Collection<Movie> getAll() {
        return movieService.getAll();
    }

    @PostMapping
    public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PostMapping("/r")
    public Collection<Movie> getRecommendationFor(@RequestBody User user) {
        return movieService.getRecommendationFor(user);
    }
}
