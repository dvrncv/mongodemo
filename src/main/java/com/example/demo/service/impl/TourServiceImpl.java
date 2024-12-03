package com.example.demo.service.impl;

import com.example.demo.Dto.TourDto;
import com.example.demo.model.Tour;
import com.example.demo.repository.TourRepository;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public long countTours() {
        return tourRepository.count();
    }

    @Override
    @CacheEvict(value = "page")
    public TourDto createTour(TourDto tourCreateDto) {
        Tour tour = fromDtoToTour(tourCreateDto);
        tourRepository.save(tour);
        return fromTourToDto(tour);
    }

    @Override
    @Cacheable("page")
    public List<Tour> getTours(Pageable pageable) {
        List<Tour> tours = tourRepository.findAll(pageable).toList();
        return tours;

    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTour(String id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour с id=" + id + " не найден"));
    }

    @Override
    @CacheEvict(value = "page", allEntries = true)
    public void deleteTour(String id) {
        tourRepository.deleteById(id);
    }

    @Override
    public void deleteAllTours() {
        tourRepository.deleteAll();
    }

    @Override
    @CacheEvict(value = "page")
    public void updateTour(TourDto tourDto) {
        Tour tour = getTour(tourDto.getId());

        tour.setDestination(tourDto.getDestination());
        tour.setPrice(tourDto.getPrice());
        tour.setDuration(tourDto.getDuration());
        tour.setFeatures(tourDto.getFeatures());
        tour.setStartDate(tourDto.getStartDate());
        tour.setFinishDate(tourDto.getFinishDate());
        tour.setRating(tourDto.getRating());

        tourRepository.save(tour);
    }

    @Override
    public List<Tour> getToursByPrice(int price) {
        return tourRepository.findByPrice(price);
    }

    @Override
    public List<Tour> getToursByDestination(String destination) {
        return tourRepository.getByDestination(destination);
    }

    private Tour fromDtoToTour(TourDto tourDto) {

        return new Tour(
                tourDto.getId(),
                tourDto.getDestination(),
                tourDto.getPrice(),
                tourDto.getDuration(),
                tourDto.getFeatures(),
                tourDto.getStartDate(),
                tourDto.getFinishDate(),
                tourDto.getRating()
        );
    }

    private TourDto fromTourToDto(Tour tour) {
        return new TourDto(
                tour.getId(),
                tour.getDestination(),
                tour.getPrice(),
                tour.getDuration(),
                tour.getFeatures(),
                tour.getStartDate(),
                tour.getFinishDate(),
                tour.getRating()
        );
    }
}


