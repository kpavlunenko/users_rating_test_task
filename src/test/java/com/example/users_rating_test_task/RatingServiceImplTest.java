package com.example.users_rating_test_task;

import com.example.users_rating_test_task.persistence.db.RatingDB;
import com.example.users_rating_test_task.persistence.entity.Rating;
import com.example.users_rating_test_task.service.LevelService;
import com.example.users_rating_test_task.service.RatingService;
import com.example.users_rating_test_task.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class RatingServiceImplTest {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private UserService userService;

    @Autowired
    private LevelService levelService;

    @Autowired
    private RatingDB ratingDB;

    @BeforeAll
    void setUp() {
        for (int i = 0; i < 20; i++) {
            Rating rating = new Rating();
            rating.setUser(userService.findById(1l));
            rating.setLevel(levelService.findById(1l + i));
            rating.setResult(1l + i);
            ratingService.create(rating);
        }

        Assertions.assertEquals(20, ratingService.findAll().size());
    }

    @Test
    void shouldBeAddNewRatingForNewLevel() {
        Rating rating = new Rating();
        rating.setUser(userService.findById(1l));
        rating.setLevel(levelService.findById(21l));
        rating.setResult(21l);
        ratingService.create(rating);

        Assertions.assertEquals(21, ratingService.findAll().size());
    }

    @Test
    void shouldBeUpdateRatingWhenResultIsBetter() {
        Rating rating = new Rating();
        rating.setUser(userService.findById(1l));
        rating.setLevel(levelService.findById(21l));
        rating.setResult(100l);
        ratingService.create(rating);

        Assertions.assertEquals(21, ratingService.findAll().size());

        Optional<Rating> ratingOptional = ratingService.findAll().stream()
                .filter(ratingFilter -> ratingFilter.getUser().getId().equals(1l)
                        &&ratingFilter.getLevel().getId().equals(21l))
                .findFirst();

        Assertions.assertTrue(ratingOptional.isPresent());
        Assertions.assertEquals(100l, ratingOptional.get().getResult());
    }

    @Test
    void shouldBeNorCreatedRatingWhenResultIsNotBetter() {
        int sizeOfItems = ratingService.findAll().size();
        Rating rating = new Rating();
        rating.setUser(userService.findById(1l));
        rating.setLevel(levelService.findById(20l));
        rating.setResult(1l);
        ratingService.create(rating);

        Assertions.assertEquals(sizeOfItems, ratingService.findAll().size());
    }

    @AfterAll
    void clearDB() {
        ratingDB.clear();
    }

}
