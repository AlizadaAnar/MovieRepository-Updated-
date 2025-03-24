package org.moviexample.movieapidev.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;

    private String title;

    private String genre;

    private String director;

    private double iMDbRating;

    private Integer release_year;
}
