package com.example.users_rating_test_task.persistence.db;

import com.example.users_rating_test_task.persistence.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseDB<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    Optional<ENTITY> findById(Long id);
    List<ENTITY> findAll();
}
