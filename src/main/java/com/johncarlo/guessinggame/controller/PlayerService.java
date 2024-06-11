package com.johncarlo.guessinggame.controller;

import com.johncarlo.guessinggame.model.Player;
import com.johncarlo.guessinggame.model.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public String signupPlayer(Player player) {
        if(player.getUsername() == null || !player.getUsername().matches("^[A-Za-z0-9]{4,}$")) {
            return "Username must be at least 4 characters and contain only letters and numbers";
        }
        if(player.getEmail() == null || !player.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return "Invalid email format";
        }
        if(player.getPassword() == null || player.getPassword().length() < 8) {
            return "Password must be at least 8 characters";
        }
        if(!player.getPassword().equals(player.getConfirmPassword())) {
            return "Passwords do not match";
        }
        if(playerRepository.findOneByEmail(player.getEmail()) != null) {
            return "Username already exists";
        }

        playerRepository.save(player);

        return null;
    }

    public Player login(Player player) {
        return playerRepository.findOneByEmailAndPassword(player.getEmail(), player.getPassword());
    }
}
