package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RelationshipEntity
public class InLanguageRelationship {

    @GraphId
    private String emailId;

    @StartNode
    private Viewer viewer;

    @EndNode
    private Documentary documentary;
    @EndNode
    private Movie movie;
    @EndNode
    private TvEpisodes tvEpisodes;
    @EndNode
    private WebSeries webSeries;
}
