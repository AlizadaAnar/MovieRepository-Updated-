package org.moviexample.movieapidev.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.moviexample.movieapidev.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Long> {

    Logger log = LoggerFactory.getLogger(MovieRepo.class);

    default List<MovieEntity> findByGenreWithLog(String genre) {
        log.info("Find movies by genre {}", genre);
        List<MovieEntity> movieEntities = findByGenre(genre);
        log.info("Found {} movies with genre {}", movieEntities.size(), genre);
        return null;
    }

    List<MovieEntity>findByGenre(String genre);

}
