package com.example.users_rating_test_task.service.impl;

import com.example.users_rating_test_task.persistence.dao.UserDao;
import com.example.users_rating_test_task.persistence.entity.User;
import com.example.users_rating_test_task.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User entity) {
        userDao.create(entity);
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userDao.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            User user = new User();
            user.setId(id);
            create(user);
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
