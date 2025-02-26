package org.moviexample.movieapidev.Service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.moviexample.movieapidev.Entity.MovieEntity;
import org.moviexample.movieapidev.Repository.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepo movieRepo;

    public MovieEntity addMovie(MovieEntity movieEntity) {
        log.info("Adding new movie: -> {}", movieEntity.getTitle());
        MovieEntity savedMovie = movieRepo.save(movieEntity);
        log.info("Movie added successfully with ID : {}", savedMovie.getId());
        return savedMovie;

    }

    public MovieEntity updateMovies(Long id, MovieEntity updatedMovies) {
        log.info("Updating movie: -> {}", id);
        return movieRepo.findById(id).map(contMovie -> {
            contMovie.setGenre(updatedMovies.getGenre());
            contMovie.setTitle(updatedMovies.getTitle());
            contMovie.setYear(updatedMovies.getYear());
            contMovie.setDirector(updatedMovies.getDirector());
            contMovie.setIMDbRating(updatedMovies.getIMDbRating());
            MovieEntity updatedMovie = movieRepo.save(contMovie);
            log.info("Movie updated successfully with ID : {}", id);
            return updatedMovie;
        }).orElseThrow(() -> {
            log.info("Movie not found with ID : {}", id);
            return new RuntimeException("Movie not found with id: " + id);
        });
    }

    public List<MovieEntity> getAllMovies() {
        log.info("Fetching all movies from DB..");
        List<MovieEntity> movies = movieRepo.findAll();
        log.info("Movies fetched successfully {}", movies.size());
        return movies;
    }

    public Optional<MovieEntity> getMovieById(Long id) {
        log.info("Fetching movie by ID: {}", id);
        return movieRepo.findById(id);
    }

    public void deleteMovie(Long id) {
        log.warn("Deleting movie with ID: {}", id);
        movieRepo.deleteById(id);
        log.info("Movie deleted successfully with ID : {}", id);
    }
}


