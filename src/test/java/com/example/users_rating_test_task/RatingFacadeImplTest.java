package com.example.users_rating_test_task;

import com.example.users_rating_test_task.api.dto.request.RatingRequestDto;
import com.example.users_rating_test_task.facade.RatingFacade;
import com.example.users_rating_test_task.persistence.db.RatingDB;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class RatingFacadeImplTest {

    @Autowired
    private RatingFacade ratingFacade;

    @Autowired
    private RatingDB ratingDB;

    @BeforeAll
    void setUp() {
        for (int i = 0; i < 30; i++) {
            RatingRequestDto ratingRequestDto = new RatingRequestDto();
            ratingRequestDto.setUser_id(2l);
            ratingRequestDto.setLevel_id(1l + i);
            ratingRequestDto.setResult(1l + i);
            ratingFacade.setInfo(ratingRequestDto);
        }

        Assertions.assertEquals(20, ratingFacade.userInfo(2l).size());
    }

    @Test
    void shouldBeReturnTop20OfRating() {
        RatingRequestDto ratingRequestDto = new RatingRequestDto();
        ratingRequestDto.setUser_id(2l);
        ratingRequestDto.setLevel_id(31l);
        ratingRequestDto.setResult(31l);
        ratingFacade.setInfo(ratingRequestDto);

        Assertions.assertEquals(20, ratingFacade.userInfo(2l).size());
    }

    @Test
    void shouldBeSortedRatingByResultWhenManyRatingForUser() {
        RatingRequestDto ratingRequestDto = new RatingRequestDto();
        ratingRequestDto.setUser_id(2l);
        ratingRequestDto.setLevel_id(31l);
        ratingRequestDto.setResult(100l);
        ratingFacade.setInfo(ratingRequestDto);

        Assertions.assertEquals(100l, ratingFacade.userInfo(2l).stream().findFirst().get().getResult());
    }

    @Test
    void shouldBeSortedRatingByResultWhenManyRatingForLevel() {
        RatingRequestDto ratingRequestDto = new RatingRequestDto();
        ratingRequestDto.setUser_id(2l);
        ratingRequestDto.setLevel_id(40l);
        ratingRequestDto.setResult(100l);
        ratingFacade.setInfo(ratingRequestDto);

        ratingRequestDto.setUser_id(3l);
        ratingRequestDto.setLevel_id(40l);
        ratingRequestDto.setResult(110l);
        ratingFacade.setInfo(ratingRequestDto);

        Assertions.assertEquals(110l, ratingFacade.levelInfo(40l).stream().findFirst().get().getResult());
    }

    @AfterAll
    void clearDB() {
        ratingDB.clear();
    }
}
