package com.johncarlo.guessinggame.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long>{

    Player findOneByEmail(String email);

    Player findOneByEmailAndPassword(String email, String password);

}
