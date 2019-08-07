package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandaloneMedia {
    @Id
    private String mediaTitle;
    private String mediaCategory;
    private String mediaSynopsis;
    private List<String> mediaGenre;
    private String mediaLanguage;
    private Date mediaReleaseDate;
    private String mediaPosterUrl;
    private String mediaStudioName;
    private List<Crew> mediaCrew;
    private List<Cast> mediaCast;
    private String mediaUrl;
    private String mediaTrailerUrl;
    private String mediaType;
}
