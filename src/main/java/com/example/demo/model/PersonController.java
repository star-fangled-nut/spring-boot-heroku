package com.example.demo.model;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://boiling-bastion-39947.herokuapp.com")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/helloEndpoint")
    Collection<Person> helloEndpoint() {
        return (Collection<Person>) personRepository.findAll();
    }
}
