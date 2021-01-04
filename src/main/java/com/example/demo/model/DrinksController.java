package com.example.demo.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DrinksController {

    private final DrinksRepository drinksRepository;

    public DrinksController(DrinksRepository drinksRepository) {
        this.drinksRepository = drinksRepository;
    }

    @GetMapping("/drinks")
    Collection<Drink> getAllDrinks() {
        return drinksRepository.findAll();
    }

    @GetMapping("/drinksThisWeek")
    Collection<Drink> getDrinksThisWeek() {
        Week currentWeek = new Week();

        return drinksRepository.drinksThisWeek(currentWeek.getStartDate(), currentWeek.getEndDate());
    }

    @DeleteMapping(value = "/drink/{id}")
    void deleteDrink(@PathVariable Long id) {
        drinksRepository.deleteById(id);
    }

    @GetMapping("/drink/{id}")
    Optional<Drink> getDrink(@PathVariable Long id) {
        return drinksRepository.findById(id);
    }

    @PostMapping("/addDrink")
    ResponseEntity<Drink> createPerson(@RequestBody Drink drink) {
        drink.setDate();
        Drink result = drinksRepository.save(drink);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/totalUnits")
    double getTotalUnits() {
        return drinksRepository.getTotal();
    }

    @GetMapping("/totalUnitsThisWeek")
    double getTotalUnitsThisWeek() {
        Week currentWeek = new Week();

        if(getDrinksThisWeek().isEmpty()) {
            return 0;
        } else {
            return drinksRepository.getTotalThisWeek(currentWeek.getStartDate(), currentWeek.getEndDate());
        }
    }

    @GetMapping("/currentWeek")
    HashMap<String, String> getCurrentWeek() {
        Week currentWeek = new Week();

        HashMap<String, String> currentWeekMap = new HashMap<>();
        currentWeekMap.put("startDate", currentWeek.getStartDate().toString());
        currentWeekMap.put("endDate", currentWeek.getEndDate().toString());
        return currentWeekMap;
    }
}
