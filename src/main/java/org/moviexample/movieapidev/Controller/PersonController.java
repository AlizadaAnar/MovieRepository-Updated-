package org.moviexample.movieapidev.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.moviexample.movieapidev.Service.PersonService;
import org.moviexample.movieapidev.model.entity.PersonEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
@Tag(name = "Person Api", description = "CRUD operations for Person ")
@Slf4j
public class PersonController {

    private final PersonService personService;

    @GetMapping("/getPersonById/{id}")
    @Operation(summary = "Get person by id")
    public ResponseEntity<Optional<PersonEntity>> getPersonById(@PathVariable Long id) {
        log.info("Received request to retrieve persons by id");
        Optional<PersonEntity> personById = personService.getPersonById(id);
        return ResponseEntity.ok(personById);
    }

    @PostMapping("/add/person")
    @Operation(summary = "Adding new person")
    public ResponseEntity<PersonEntity> addPerson(@Valid @RequestBody PersonEntity personEntity) {
        log.info("Adding new movie requested {}", personEntity.getName());
        return ResponseEntity.ok(personService.addPerson(personEntity));
    }
}
