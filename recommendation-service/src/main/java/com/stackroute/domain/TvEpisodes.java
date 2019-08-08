package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NodeEntity
public class TvEpisodes {

    @GraphId
    private Long id;
    private String episodicTitle;
    private String episodicCategory;
    private String episodicLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpisodicTitle() {
        return episodicTitle;
    }

    public void setEpisodicTitle(String episodicTitle) {
        this.episodicTitle = episodicTitle;
    }

    public String getEpisodicCategory() {
        return episodicCategory;
    }

    public void setEpisodicCategory(String episodicCategory) {
        this.episodicCategory = episodicCategory;
    }

    public String getEpisodicLanguage() {
        return episodicLanguage;
    }

    public void setEpisodicLanguage(String episodicLanguage) {
        this.episodicLanguage = episodicLanguage;
    }
}
