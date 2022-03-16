package com.example.users_rating_test_task.persistence.db.impl;

import com.example.users_rating_test_task.persistence.db.UserDB;
import com.example.users_rating_test_task.persistence.entity.Rating;
import com.example.users_rating_test_task.persistence.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDBImpl implements UserDB {

    private List<User> users;

    public UserDBImpl() {
        this.users = new ArrayList<User>();
    }

    @Override
    public void create(User entity) {
        users.add(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void clear() {
        this.users = new ArrayList<User>();
    }
}
