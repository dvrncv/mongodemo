package com.example.demo.Dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

public class TourDto {
    private String id;
    private String destination;
    private Integer price;
    private Integer duration;
    private List<String> features;
    private String  startDate;
    private String finishDate;
    private Integer rating;

    public TourDto(String id, String destination, Integer price, Integer duration, List<String> features, String startDate, String finishDate, Integer rating) {
        this.id = id;
        this.destination = destination;
        this.price = price;
        this.duration = duration;
        this.features = features;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures (List<String> features) {
        this.features = features;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}