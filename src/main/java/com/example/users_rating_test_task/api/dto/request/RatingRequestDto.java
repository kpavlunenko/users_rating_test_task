package com.example.users_rating_test_task.api.dto.request;

public class RatingRequestDto {

    private Long user_id;
    private Long level_id;
    private Long result;

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

    @Override
    public String toString() {
        return "RatingRequestDto{" +
                "user_id=" + user_id +
                ", level_id=" + level_id +
                ", result=" + result +
                '}';
    }
}
