package com.example.demo.controller;

import com.example.demo.Dto.TourDto;
import com.example.demo.model.Tour;
import com.example.demo.service.TourService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin
public class TourController {

    private final TourService service;

    public TourController(TourService service) {
        this.service = service;
    }

    @GetMapping("/tours")
    public Page<Tour> getToursPage(
            @RequestParam(defaultValue = "0") @Min(0) Integer offset,              
            @RequestParam(defaultValue = "40") @Min(1) @Max(100) Integer limit
    ) {
        return service.getTours(PageRequest.of(offset, limit));
    }

    @GetMapping("/tours/{id}")
    public Tour getTour(@PathVariable String id) {
        return service.getTour(id);
    }

    @PostMapping("/tours")
    public TourDto createTour(@RequestBody TourDto tour) {
        return service.createTour(tour);
    }

    @DeleteMapping("/tours/{id}")
    public void deleteTour(@PathVariable String id) {
        service.deleteTour(id);
    }

    @GetMapping("/tours/price/{price}")
    public List<Tour> getToursByPrice(@PathVariable @Min(0) int price) {
        return service.getToursByPrice(price);
    }

    @GetMapping("/tours/destination/{destination}")
    public List<Tour> getToursByDestination(@PathVariable String destination) {
        return service.getToursByDestination(destination);
    }

    @PutMapping("/tours")
    public void putTours(@RequestBody TourDto newTour) {
        service.updateTour(newTour);
    }
}