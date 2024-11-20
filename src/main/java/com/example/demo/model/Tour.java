package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "travel_agency")
public class Tour {
    @Id
    private String id;
    @Field(name = "destination")
    private String destination;
    @Field(name = "price")
    private Integer price;
    @Field(name = "duration")
    private Integer duration;
    @Field(name = "features")
    private List<String> features;
    @Field(name = "start_date")
    private String startDate;
    @Field(name = "finish_date")
    private String finishDate;
    @Field(name = "rating")
    private Integer rating;

    protected Tour() {
    }

    public Tour(String id, String destination, Integer price, Integer duration, List<String> features, String startDate, String finishDate, Integer rating) {
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

    public List<String> getFeatures () {
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


//    @Override
//    public String toString() {
//        return "Tour{" +
//                "id='" + id + '\'' +
//                ", location='" + location + '\'' +
//                ", price='" + price + '\'' +
//                ", duration='" + duration + '\'' +
//                ", features='" + feature + '\'' +
//                ", startDate='" + startDate + '\'' +
//                ", finishDate='" + finishDate + '\'' +
//                ", rating=" + rating +
//                '}';
//    }
}
