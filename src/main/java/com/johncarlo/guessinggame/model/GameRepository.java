package com.johncarlo.guessinggame.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findFirstByPlayerIdAndStatusIsOrderByPlayedAtDesc(Long playerId, Status status);

    int countByPlayerIdAndStatus(Long playerId, Status status);
}
