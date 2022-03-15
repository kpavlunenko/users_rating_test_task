package com.example.users_rating_test_task.service;

import com.example.users_rating_test_task.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseService<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    ENTITY findById(Long id);
    List<ENTITY> findAll();
}
