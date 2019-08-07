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
}
