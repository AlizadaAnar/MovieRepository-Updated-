package org.moviexample.movieapidev.Repository;


import org.moviexample.movieapidev.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Long> {
}
