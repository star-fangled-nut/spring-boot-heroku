package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoader implements CommandLineRunner {

    private final PersonRepository repository;

    @Autowired
    public DemoLoader(PersonRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new Person("John", "Smith"));
    }
}
