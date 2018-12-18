package com.kpi.neo4jlab.repository;

import com.kpi.neo4jlab.model.Movie;
import com.kpi.neo4jlab.model.Rating;
import com.kpi.neo4jlab.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RatingRepository extends Neo4jRepository<Rating, Long> {

    @Query("MATCH (u:User)<-[r:RATED]-(m:Movie) WHERE ID(m)={0} AND ID(u)={1} RETURN r")
    Rating findByMovieAndUser(Movie movie, User user);
}
