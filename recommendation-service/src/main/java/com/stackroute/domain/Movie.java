package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NodeEntity
public class Movie {

    @GraphId
    private Long id;
    private String mediaTitle;
    private String mediaCategory;
    private List<String> mediaGenre;
    private String mediaLanguage;
}
