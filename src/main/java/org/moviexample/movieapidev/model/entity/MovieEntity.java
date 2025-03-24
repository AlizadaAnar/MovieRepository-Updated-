package org.moviexample.movieapidev.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Movies")
public class MovieEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String title;

    @NotBlank(message = "genre is required")
    private String genre;

    @NotEmpty(message = "director is required")
    private String director;

    @DecimalMin(value = "0.0", inclusive = true, message = "IMDb rating must be at least 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "IMDb rating must be at most 10.0")
    private double iMDbRating;

    @Min(value = 1900, message = "Release year must be greater than or equal to 1900")
    @Max(value = 2100, message = "Release year must be less than or equal to 2100")
    private Integer release_year;

}
