package com.example.users_rating_test_task.persistence.db.impl;

import com.example.users_rating_test_task.persistence.db.LevelDB;
import com.example.users_rating_test_task.persistence.entity.Level;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LevelDBImpl implements LevelDB {

    private List<Level> levels;

    public LevelDBImpl() {
        this.levels = new ArrayList<Level>();
    }

    @Override
    public void create(Level entity) {
        levels.add(entity);
    }

    @Override
    public Optional<Level> findById(Long id) {
        return levels.stream()
                .filter(level -> level.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Level> findAll() {
        return levels;
    }
}
