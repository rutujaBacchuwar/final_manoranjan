package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RelationshipEntity
public class InterestedInRelationship  {

    @GraphId
    private String emailId;

    @StartNode
    private User user;

    @EndNode
    private Genre genre;

}
