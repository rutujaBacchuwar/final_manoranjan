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
}