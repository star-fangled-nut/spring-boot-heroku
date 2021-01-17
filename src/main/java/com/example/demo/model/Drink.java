package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Drink {

    private @Id @GeneratedValue Long id;
    private double units;
    private int volume;
    private double abv;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    public void setDate() {
        this.date = LocalDate.now();
    }

    public void calculateUnits() {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        this.units = Double.parseDouble(decimalFormat.format((volume * abv) /1000));
    }
}
