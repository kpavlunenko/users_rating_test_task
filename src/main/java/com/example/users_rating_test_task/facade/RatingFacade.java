package com.example.users_rating_test_task.facade;

import com.example.users_rating_test_task.api.dto.request.RatingRequestDto;
import com.example.users_rating_test_task.api.dto.response.RatingResponseDto;

import java.util.List;

public interface RatingFacade {

    void setInfo(RatingRequestDto ratingRequestDto);
    List<RatingResponseDto> levelInfo(Long id);
    List<RatingResponseDto> userInfo(Long id);
}
