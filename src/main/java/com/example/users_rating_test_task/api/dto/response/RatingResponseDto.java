package com.example.users_rating_test_task.api.dto.response;

import com.example.users_rating_test_task.persistence.entity.Rating;

public class RatingResponseDto {

    private Long user_id;
    private Long level_id;
    private Long result;

    public RatingResponseDto() {
    }

    public RatingResponseDto(Rating rating) {
        this.user_id = rating.getUser().getId();
        this.level_id = rating.getLevel().getId();
        this.result = rating.getResult();
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getLevel_id() {
        return level_id;
    }

    public void setLevel_id(Long level_id) {
        this.level_id = level_id;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}
