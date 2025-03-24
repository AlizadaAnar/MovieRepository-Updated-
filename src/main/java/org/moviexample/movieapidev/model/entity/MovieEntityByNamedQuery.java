package org.moviexample.movieapidev.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.moviexample.movieapidev.model.enumeration.BookStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Access(AccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "MovieEntityByNamedQuery.findAll", query = "select m from MovieEntityByNamedQuery m"),
        @NamedQuery(name = "MovieEntityByNamedQuery.findByEmailAndTitle", query = "select m from MovieEntityByNamedQuery m where m.email = :email and m.title = :title")
})
@Table(
        name = "Movies",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"EMAIL"})
        }
)
public class MovieEntityByNamedQuery {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @Enumerated(EnumType.ORDINAL)
    private BookStatus bookStatus;

    @NotBlank(message = "genre is required")
    @Column(name = "GENRE", nullable = false, length = 50)
    private String genre;

    @NotEmpty(message = "director is required")
    private String director;

    @NotBlank(message = "email can not be empty")
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @DecimalMin(value = "0.0", inclusive = true, message = "IMDb rating must be at least 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "IMDb rating must be at most 10.0")
    private double iMDbRating;

    //    @Min(value = 1900, message = "Release year must be greater than or equal to 1900")
//    @Max(value = 2100, message = "Release year must be less than or equal to 2100")
    @JsonProperty("releaseYear")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseYear;

    @Transient
    private String ageRating;

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getiMDbRating() {
        return iMDbRating;
    }

    public void setiMDbRating(double iMDbRating) {
        this.iMDbRating = iMDbRating;
    }

    public LocalDate getRelease_year() {
        return releaseYear;
    }

    public void setRelease_year(LocalDate release_year) {
        this.releaseYear = release_year;
    }

    public String getEmail() {
        return email;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", iMDbRating=" + iMDbRating +
                ", release_year=" + releaseYear +
                '}';
    }
}
