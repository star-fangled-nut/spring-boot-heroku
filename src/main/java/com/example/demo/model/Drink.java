package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Drink {

    private @Id @GeneratedValue Long id;
    private double units;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    public Drink(double units) {
        this.units = units;
        this.date = LocalDate.now();
    }

    public void setDate() {
        this.date = LocalDate.now();
    }
}
