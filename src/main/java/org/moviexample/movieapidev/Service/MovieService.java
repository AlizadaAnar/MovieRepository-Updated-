//package org.moviexample.movieapidev.Service;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.moviexample.movieapidev.Repository.PersonRepo;
//import org.moviexample.movieapidev.exception.PersonNotFoundException;
//import org.moviexample.movieapidev.model.entity.MovieEntity;
//import org.moviexample.movieapidev.Repository.MovieRepo;
//import org.moviexample.movieapidev.exception.MovieNotFoundException;
//import org.moviexample.movieapidev.model.entity.PersonEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class MovieService {
//
//    private final MovieRepo movieRepo;
//
//
//    public MovieEntity addMovie(MovieEntity movieEntity) {
//        log.info("Adding new movie: -> {}", movieEntity.getTitle());
//        MovieEntity savedMovie = movieRepo.save(movieEntity);
//        log.info("Movie added successfully with ID : {}", savedMovie.getId());
//        return savedMovie;
//
//    }
//
//
//    public MovieEntity updateMovies(Long id, MovieEntity updatedMovies) {
//        log.info("Updating movie: -> {}", id);
//        return movieRepo.findById(id).map(contMovie -> {
//            contMovie.setGenre(updatedMovies.getGenre());
//            contMovie.setTitle(updatedMovies.getTitle());
//            contMovie.setRelease_year(updatedMovies.getRelease_year());
//            contMovie.setDirector(updatedMovies.getDirector());
//            contMovie.setiMDbRating(updatedMovies.getiMDbRating());
//            MovieEntity updatedMovie = movieRepo.save(contMovie);
//            log.info("Movie updated successfully with ID : {}", id);
//            return updatedMovie;
//        }).orElseThrow(() ->
//                new MovieNotFoundException("Movie with id: " + id + " not found"));
//    }
//
//    public List<MovieEntity> getAllMovies() {
//        log.info("Fetching all movies from DB..");
//        List<MovieEntity> movies = movieRepo.findAll();
//        log.info("Movies fetched successfully {}", movies.size());
//        return movies;
//    }
//
//    public Optional<MovieEntity> getMovieById(Long id) {
//        log.info("Fetching movie by ID: {}", id);
//        return Optional.ofNullable(movieRepo.findById(id).orElseThrow(() ->
//                new MovieNotFoundException("Movie with id: " + id + " not found")));
//    }
//
//
//
//    public void deleteMovie(Long id) {
//        log.warn("Deleting movie with ID: {}", id);
//        movieRepo.findById(id)
//                .ifPresentOrElse(movieRepo::delete,
//                        () -> {
//                            throw new MovieNotFoundException("Movie with id: " + id + " not found");
//                        });
//        log.info("Movie deleted successfully with ID : {}", id);
//    }
//
//
//    public void deleteMovie2(Long id) {
//        if(!movieRepo.existsById(id)) {
//            throw new MovieNotFoundException("Movie with id: " + id + " not found");
//        }
//        movieRepo.deleteById(id);
//        log.info("Successfully deleted!!");
//    }
//
//}
//
//
