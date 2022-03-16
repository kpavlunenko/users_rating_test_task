package com.example.users_rating_test_task.service.impl;

import com.example.users_rating_test_task.persistence.dao.RatingDao;
import com.example.users_rating_test_task.persistence.entity.Rating;
import com.example.users_rating_test_task.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    private final Logger logger = LoggerFactory.getLogger("info");
    private final RatingDao ratingDao;

    public RatingServiceImpl(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Override
    public void create(Rating entity) {
        List<Rating> ratings = findAll();
        Optional<Rating> ratingOptional = ratings.stream()
                .filter(rating -> rating.getUser().getId().equals(entity.getUser().getId())
                        &&rating.getLevel().getId().equals(entity.getLevel().getId()))
                .findFirst();
        if (ratingOptional.isEmpty()) {
            logger.info("object: Rating; stage: start; operation: create; " + entity.toString());
            ratingDao.create(entity);
            logger.info("object: Rating; stage: finish; operation: create");
        } else {
            Rating rating = ratingOptional.get();
            if (rating.getResult() < entity.getResult()) {
                rating.setResult(entity.getResult());
                logger.info("object: Rating; stage: finish; operation: update; "  + rating.toString() + " on " + entity.toString());
            }
        }
    }

    @Override
    public Rating findById(Long id) {
        Optional<Rating> ratingOptional = ratingDao.findById(id);
        if (ratingOptional.isPresent()) {
            return ratingOptional.get();
        } else {
            Rating rating = new Rating();
            rating.setId(id);
            create(rating);
            return rating;
        }
    }

    @Override
    public List<Rating> findAll() {
        return ratingDao.findAll();
    }
}
