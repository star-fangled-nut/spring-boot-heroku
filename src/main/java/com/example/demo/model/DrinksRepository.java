package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.Collection;

@RepositoryRestResource
public interface DrinksRepository extends JpaRepository<Drink, Long> {

    @Query(value = "SELECT SUM(Units) From DRINK", nativeQuery = true)
    double getTotal();

    @Query(value = "SELECT SUM(Units) From DRINK WHERE drink.date between :startDate and :endDate", nativeQuery = true)
    double getTotalThisWeek(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT * FROM DRINK drink WHERE drink.date between :startDate and :endDate", nativeQuery = true)
    Collection<Drink> drinksThisWeek(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
