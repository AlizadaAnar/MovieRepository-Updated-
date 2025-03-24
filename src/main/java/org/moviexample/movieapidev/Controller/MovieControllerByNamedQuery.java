package org.moviexample.movieapidev.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.moviexample.movieapidev.Service.MovieServiceByNamedQuery;
import org.moviexample.movieapidev.model.entity.MovieEntityByNamedQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies/named-query")
@RequiredArgsConstructor
@Tag(name = "Movies Api with named query", description = "CRUD operations for Movies")
@Slf4j
public class MovieControllerByNamedQuery {

    private final MovieServiceByNamedQuery movieServiceByNamedQuery;

    @GetMapping("/movie/all")
    public List<MovieEntityByNamedQuery> getAllMovies() {
        return movieServiceByNamedQuery.getAllMovies();
    }

    @GetMapping("/movie/by/email")
    public List<MovieEntityByNamedQuery> getMovieByEmail(@RequestParam String email, @RequestParam String title) {
        return movieServiceByNamedQuery.getMovieByEmail(email, title);
    }

    @PostMapping("/movie/create")
    public void createMovie(@Valid @RequestBody MovieEntityByNamedQuery movieEntity) {
         movieServiceByNamedQuery.createMovie(movieEntity);
    }


}
