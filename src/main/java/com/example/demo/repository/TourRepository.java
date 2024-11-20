package com.example.demo.repository;

import com.example.demo.model.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TourRepository extends MongoRepository<Tour, String> {
//    @Query("{_id: {$eq: ObjectId(?0)}}")
    Optional<Tour> findById(String id);
    @Query("{price: {$eq: ?0}}")
    List<Tour> findByPrice(int price);
    @Query("{destination: {$eq: ?0}}")
    List<Tour> getByDestination(String destination);
}

