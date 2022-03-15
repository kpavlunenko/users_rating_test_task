package com.example.users_rating_test_task.facade.impl;

import com.example.users_rating_test_task.api.dto.request.RatingRequestDto;
import com.example.users_rating_test_task.api.dto.response.RatingResponseDto;
import com.example.users_rating_test_task.exception.IncorrectInputData;
import com.example.users_rating_test_task.facade.RatingFacade;
import com.example.users_rating_test_task.persistence.entity.Rating;
import com.example.users_rating_test_task.service.LevelService;
import com.example.users_rating_test_task.service.RatingService;
import com.example.users_rating_test_task.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingFacadeImpl implements RatingFacade {

    private final UserService userService;
    private final LevelService levelService;
    private final RatingService ratingService;

    public RatingFacadeImpl(UserService userService, LevelService levelService, RatingService ratingService) {
        this.userService = userService;
        this.levelService = levelService;
        this.ratingService = ratingService;
    }

    @Override
    public void setInfo(RatingRequestDto ratingRequestDto) {
        if (ratingRequestDto.getResult() == null) {
            throw new IncorrectInputData("result can not be empty");
        }
        if (ratingRequestDto.getUser_id() == null) {
            throw new IncorrectInputData("user can not be empty");
        }
        if (ratingRequestDto.getLevel_id() == null) {
            throw new IncorrectInputData("level can not be empty");
        }
        Rating rating = new Rating();
        rating.setUser(userService.findById(ratingRequestDto.getUser_id()));
        rating.setLevel(levelService.findById(ratingRequestDto.getLevel_id()));
        rating.setResult(ratingRequestDto.getResult());
        ratingService.create(rating);
    }

    @Override
    public List<RatingResponseDto> levelInfo(Long id) {
        List<Rating> all = ratingService.findAll();
        List<RatingResponseDto> items = all.stream()
                .filter(rating -> rating.getLevel().getId().equals(id))
                .sorted(Comparator.comparingLong(Rating::getResult).reversed())
                .limit(20)
                .map(RatingResponseDto::new)
                .collect(Collectors.toList());
        return items;
    }

    @Override
    public List<RatingResponseDto> userInfo(Long id) {
        List<Rating> all = ratingService.findAll();
        List<RatingResponseDto> items = all.stream()
                .filter(rating -> rating.getUser().getId().equals(id))
                .sorted(Comparator.comparingLong(Rating::getResult).reversed())
                .limit(20)
                .map(RatingResponseDto::new)
                .collect(Collectors.toList());
        return items;
    }
}
