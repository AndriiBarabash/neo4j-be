package com.kpi.neo4jlab.repository;

import com.kpi.neo4jlab.model.Movie;
import com.kpi.neo4jlab.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("MATCH (res:User)<-[:RATED]-(:Movie)-[:RATED]->(:User)<-[:RATED]-(m:Movie) WHERE NOT (res)<-[:RATED]-(m) AND ID(m)={movieId} RETURN res")
    Collection<User> getRecommendationFor(@Param("movieId") Movie movie);

    User findByNameAndAge(String name, Integer age);
}
