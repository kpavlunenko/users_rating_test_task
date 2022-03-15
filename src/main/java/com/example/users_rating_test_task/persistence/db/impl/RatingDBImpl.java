package com.example.users_rating_test_task.persistence.db.impl;

import com.example.users_rating_test_task.persistence.db.RatingDB;
import com.example.users_rating_test_task.persistence.entity.Rating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RatingDBImpl implements RatingDB {

    private List<Rating> ratings;

    public RatingDBImpl() {
        this.ratings = new ArrayList<Rating>();
    }

    @Override
    public void create(Rating entity) {
        ratings.add(entity);
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return ratings.stream()
                .filter(rating -> rating.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Rating> findAll() {
        return ratings;
    }
}
