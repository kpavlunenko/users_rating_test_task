package com.example.users_rating_test_task.persistence.dao.impl;

import com.example.users_rating_test_task.persistence.dao.UserDao;
import com.example.users_rating_test_task.persistence.db.UserDB;
import com.example.users_rating_test_task.persistence.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserDB userDB;

    public UserDaoImpl(UserDB userDB) {
        this.userDB = userDB;
    }

    @Override
    public void create(User entity) {
        userDB.create(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDB.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDB.findAll();
    }
}
