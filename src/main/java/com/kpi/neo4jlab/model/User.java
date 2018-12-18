package com.kpi.neo4jlab.model;


import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.List;

@Getter
@Setter
@NodeEntity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;

    @Relationship(type = "RATED", direction = Relationship.INCOMING)
    private List<Movie> movies;
}
