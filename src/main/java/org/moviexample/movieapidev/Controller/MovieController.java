//package org.moviexample.movieapidev.Controller;
//
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.moviexample.movieapidev.model.entity.MovieEntity;
//import org.moviexample.movieapidev.Service.MovieService;
//import org.moviexample.movieapidev.model.entity.PersonEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/movies")
//@RequiredArgsConstructor
//@Tag(name = "Movies Api", description = "CRUD operations for Movies ")
//@Slf4j
//public class MovieController {
//
//    private final MovieService movieService;
//
//    @GetMapping("/getAllMoviesByID/{id}")
//    @Operation(summary = "Get all movies due to command")
//    public ResponseEntity<List<MovieEntity>> getAllMovies(@PathVariable String id) {
//        log.info("Received request to retrieve all movies due to command");
//        return ResponseEntity.ok(movieService.getAllMovies());
//    }
//
//
//    @GetMapping("getMoviesByID/{id}")
//    @Operation(summary = "Getting movies by id")
//    public ResponseEntity<Optional<MovieEntity>> getMovieById(@PathVariable Long id) {
//        log.info("Received request to retrieve movies by id");
//        Optional<MovieEntity> movieById = movieService.getMovieById(id);
//        return ResponseEntity.ok(movieById);
//    }
//
//
//
//    @PostMapping
//    @Operation(summary = "Adding new movie")
//    public ResponseEntity<MovieEntity> addMovie(@Valid @RequestBody MovieEntity movieEntity) {
//        log.info("Adding new movie requested {}", movieEntity.getTitle());
//        return ResponseEntity.ok(movieService.addMovie(movieEntity));
//    }
//
//
//
//    @PutMapping("/{id}")
//    @Operation(summary = "update movie by Id")
//    public ResponseEntity<MovieEntity> updateMovie(@PathVariable Long id, @Valid @RequestBody MovieEntity movieEntity) {
//        log.info("Updating movie with id {}", id);
//        return ResponseEntity.ok(movieService.updateMovies(id, movieEntity));
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete movie by Id")
//    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
//        log.warn("Delete requested with id {}", id);
//        movieService.deleteMovie(id);
//        if (log.isInfoEnabled()) {
//            log.info("Movie with id {} deleted successfully", id);
//        }
//        return ResponseEntity.noContent().build();
//    }
//}
