package com.kpi.neo4jlab.resource;

import com.kpi.neo4jlab.service.RatingService;
import com.kpi.neo4jlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/rate")
public class RatingResource {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Object> setRating(@RequestBody Map<String, Long> map) {
        Long userId = map.get("userId");
        Long movieId = map.get("movieId");
        Long score = map.get("score");

        return ratingService.createRating(userId, movieId, score);
    }
}
