package org.moviexample.movieapidev.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.moviexample.movieapidev.model.entity.MovieEntityByNamedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieServiceByNamedQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MovieEntityByNamedQuery> getAllMovies() {
        return entityManager.createNamedQuery("MovieEntityByNamedQuery.findAll", MovieEntityByNamedQuery.class)
                .getResultList();
    }

    public List<MovieEntityByNamedQuery> getMovieByEmail(String email, String title) {
        return entityManager.createNamedQuery("MovieEntityByNamedQuery.findByEmailAndTitle", MovieEntityByNamedQuery.class)
                .setParameter("email", email)
                .setParameter("title", title)
                .getResultList();
    }

    @Transactional
    public void createMovie(MovieEntityByNamedQuery movieEntity) {
        entityManager.persist(movieEntity);
    }
}
