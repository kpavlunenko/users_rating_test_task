package com.example.users_rating_test_task.persistence.dao.impl;

import com.example.users_rating_test_task.persistence.dao.LevelDao;
import com.example.users_rating_test_task.persistence.db.LevelDB;
import com.example.users_rating_test_task.persistence.entity.Level;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LevelDaoImpl implements LevelDao {

    private final LevelDB levelDB;

    public LevelDaoImpl(LevelDB levelDB) {
        this.levelDB = levelDB;
    }

    @Override
    public void create(Level entity) {
        levelDB.create(entity);
    }

    @Override
    public Optional<Level> findById(Long id) {
        return levelDB.findById(id);
    }

    @Override
    public List<Level> findAll() {
        return levelDB.findAll();
    }
}
