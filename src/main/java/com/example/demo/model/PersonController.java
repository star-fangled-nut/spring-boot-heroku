package com.example.demo.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/helloEndpoint")
    Collection<Person> helloEndpoint() {
        return (Collection<Person>) personRepository.findAll();
    }

    @PostMapping("/addPerson")
    ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person result = personRepository.save(person);
        return ResponseEntity.ok().body(result);
    }
}
