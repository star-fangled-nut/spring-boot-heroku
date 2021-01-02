package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@RequiredArgsConstructor
@Getter
public class Week {

    @JsonFormat(pattern="dd-MM-yyyy")
    private final LocalDate startDate;

    @JsonFormat(pattern="dd-MM-yyyy")
    private final LocalDate endDate;

    public Week() {
        LocalDate today = LocalDate.now();
        today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.startDate = today.with(previousOrSame(MONDAY));
        this.endDate = today.with(nextOrSame(SUNDAY));
    }
}
