package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StandaloneMedia {

    @Id
    private String mediaTitle;
    private String mediaCategory;
    private List<String> mediaGenre;
    private String mediaLanguage;
    private String mediaType;

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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
