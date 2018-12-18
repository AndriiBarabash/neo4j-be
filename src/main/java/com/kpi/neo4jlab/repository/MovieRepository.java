package com.kpi.neo4jlab.repository;

import com.kpi.neo4jlab.model.Movie;
import com.kpi.neo4jlab.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie findByTitleAndDirector(String title, String director);

    @Query("MATCH (m:Movie) RETURN m")
    Collection<Movie> getAllMovies();

    @Query("MATCH (res:Movie)-[:RATED]->(:User)<-[:RATED]-(:Movie)-[:RATED]->(u:User) WHERE ID(u)={userId} AND NOT (res)-[]->(u) RETURN res")
    Collection<Movie> getRecommendationFor(@Param("userId") User user);
}
