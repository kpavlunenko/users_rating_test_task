package com.example.users_rating_test_task.persistence.entity;

public class Rating extends BaseEntity {

    private User user;
    private Level level;
    private Long result;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
