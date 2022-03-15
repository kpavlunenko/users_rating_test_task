package com.example.users_rating_test_task.persistence.dao.impl;

import com.example.users_rating_test_task.persistence.dao.RatingDao;
import com.example.users_rating_test_task.persistence.db.RatingDB;
import com.example.users_rating_test_task.persistence.entity.Rating;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RatingDaoImpl implements RatingDao {

    private final RatingDB ratingDB;

    public RatingDaoImpl(RatingDB ratingDB) {
        this.ratingDB = ratingDB;
    }

    @Override
    public void create(Rating entity) {
        ratingDB.create(entity);
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return ratingDB.findById(id);
    }

    @Override
    public List<Rating> findAll() {
        return ratingDB.findAll();
    }
}
