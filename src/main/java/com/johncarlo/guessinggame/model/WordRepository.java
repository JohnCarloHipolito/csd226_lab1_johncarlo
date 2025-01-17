package com.johncarlo.guessinggame.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

        List<Word> findByLevel(Level level);
}
