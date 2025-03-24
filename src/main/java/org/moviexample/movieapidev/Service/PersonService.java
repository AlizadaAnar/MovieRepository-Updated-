package org.moviexample.movieapidev.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.moviexample.movieapidev.Repository.PersonRepo;
import org.moviexample.movieapidev.exception.PersonNotFoundException;
import org.moviexample.movieapidev.model.entity.PersonEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private final PersonRepo personRepo;

    public PersonEntity addPerson(PersonEntity personEntity) {
        log.info("Adding new person: -> {}", personEntity.getName());
        PersonEntity savedPerson = personRepo.save(personEntity);
        log.info("Person added successfully with ID : {}", savedPerson.getId());
        return savedPerson;
    }

    public Optional<PersonEntity> getPersonById(Long id) {
        log.info("Fetching person by ID: {}", id);
        return Optional.ofNullable(personRepo.findById(id).orElseThrow(() ->
                new PersonNotFoundException("Person with id: " + id + " not found")));
    }
}
