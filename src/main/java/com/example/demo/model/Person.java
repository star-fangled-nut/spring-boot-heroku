package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Person {

    private @Id @GeneratedValue Long id;
    private String firstName;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person() {

    }
}
