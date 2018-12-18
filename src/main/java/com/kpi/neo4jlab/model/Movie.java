package com.kpi.neo4jlab.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Getter
@Setter
@NodeEntity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String director;
}
