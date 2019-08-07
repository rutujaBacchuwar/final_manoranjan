package com.stackroute.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episode {
    @Id
    private int episodeNo;
    private String episodeUrl;
    private String episodePosterUrl;
    private String episodeDescription;
    private Date episodeReleaseDate;
}
