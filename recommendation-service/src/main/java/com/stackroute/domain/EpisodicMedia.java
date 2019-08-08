package com.stackroute.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EpisodicMedia {

    @Id
    private String episodicTitle;
    private String episodicCategory;
    private String episodicLanguage;
    private String episodicType;

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

    public String getEpisodicType() {
        return episodicType;
    }

    public void setEpisodicType(String episodicType) {
        this.episodicType = episodicType;
    }
}