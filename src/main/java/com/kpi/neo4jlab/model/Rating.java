package com.kpi.neo4jlab.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@Getter
@Setter
@RelationshipEntity(type = "RATED")
public class Rating {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private Long rating;

    @StartNode
    private Movie movie;
    @EndNode
    private User user;
}
