//package org.moviexample.movieapidev.model.entity;
//
//import jakarta.persistence.Access;
//import jakarta.persistence.AccessType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.persistence.UniqueConstraint;
//import jakarta.validation.constraints.DecimalMax;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Access(AccessType.FIELD)
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(
//        name = "Movies",
////        schema = "any...",
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = {"EMAIL"})
//        }
//)
//public class MovieEntity {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Name is required")
//    @Column(name = "TITLE", nullable = false, length = 50)
//    private String title;
//
//    @NotBlank(message = "genre is required")
//    @Column(name = "GENRE", nullable = false, length = 50)
//    private String genre;
//
//    @NotEmpty(message = "director is required")
//    private String director;
//
//    @NotEmpty(message = "email can not be empty")
//    @Column(name = "EMAIL")
//    String email;
//
//    @DecimalMin(value = "0.0", inclusive = true, message = "IMDb rating must be at least 0.0")
//    @DecimalMax(value = "10.0", inclusive = true, message = "IMDb rating must be at most 10.0")
//    private double iMDbRating;
//
//    @Min(value = 1900, message = "Release year must be greater than or equal to 1900")
//    @Max(value = 2100, message = "Release year must be less than or equal to 2100")
//    private Integer release_year;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public double getiMDbRating() {
//        return iMDbRating;
//    }
//
//    public void setiMDbRating(double iMDbRating) {
//        this.iMDbRating = iMDbRating;
//    }
//
//    public Integer getRelease_year() {
//        return release_year;
//    }
//
//    public void setRelease_year(Integer release_year) {
//        this.release_year = release_year;
//    }
//
//    @Override
//    public String toString() {
//        return "MovieEntity{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", genre='" + genre + '\'' +
//                ", director='" + director + '\'' +
//                ", iMDbRating=" + iMDbRating +
//                ", release_year=" + release_year +
//                '}';
//    }
//}
