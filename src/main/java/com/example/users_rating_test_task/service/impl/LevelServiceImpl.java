package com.example.users_rating_test_task.service.impl;

import com.example.users_rating_test_task.persistence.dao.LevelDao;
import com.example.users_rating_test_task.persistence.entity.Level;
import com.example.users_rating_test_task.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {

    private final LevelDao levelDao;

    public LevelServiceImpl(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    @Override
    public void create(Level entity) {
        levelDao.create(entity);
    }

    @Override
    public Level findById(Long id) {
        Optional<Level> levelOptional = levelDao.findById(id);
        if (levelOptional.isPresent()) {
            return levelOptional.get();
        } else {
            Level level = new Level();
            level.setId(id);
            create(level);
            return level;
        }
    }

    @Override
    public List<Level> findAll() {
        return levelDao.findAll();
    }
}
