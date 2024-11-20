package com.example.demo.service;

import com.example.demo.Dto.TourDto;
import com.example.demo.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TourService {
    long countTours();
    TourDto createTour(TourDto tour);
    void updateTour(TourDto tourDto);
    Tour getTour(String id);
    void deleteTour(String id);
    void deleteAllTours();
    Page<Tour> getTours(Pageable pageable);
    List<Tour> getAllTours();
    List<Tour> getToursByPrice(int price);
    List<Tour> getToursByDestination (String destination);
}

