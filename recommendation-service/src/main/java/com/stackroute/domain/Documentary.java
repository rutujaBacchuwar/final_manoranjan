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
public class Documentary {

    @GraphId
    private Long id;
    private String mediaTitle;
    private String mediaCategory;
    private List<String> mediaGenre;
    private String mediaLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediaTitle() {
        return mediaTitle;
    }

    public void setMediaTitle(String mediaTitle) {
        this.mediaTitle = mediaTitle;
    }

    public String getMediaCategory() {
        return mediaCategory;
    }

    public void setMediaCategory(String mediaCategory) {
        this.mediaCategory = mediaCategory;
    }

    public List<String> getMediaGenre() {
        return mediaGenre;
    }

    public void setMediaGenre(List<String> mediaGenre) {
        this.mediaGenre = mediaGenre;
    }

    public String getMediaLanguage() {
        return mediaLanguage;
    }

    public void setMediaLanguage(String mediaLanguage) {
        this.mediaLanguage = mediaLanguage;
    }
}