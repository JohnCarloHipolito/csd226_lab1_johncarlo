package com.johncarlo.guessinggame.controller;

import com.johncarlo.guessinggame.model.*;
import com.johncarlo.guessinggame.model.GameRepository;
import com.johncarlo.guessinggame.model.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final WordRepository wordRepository;

    public Game startGame(Player player, Level level) {
        List<Word> words = wordRepository.findByLevel(level);
        Game game = new Game();
        game.setPlayer(player);
        game.setWord(words.get((int) (System.currentTimeMillis() % words.size())));
        game.setStatus(Status.PLAYING);
        game.setTriesLeft(5);
        game.setPlayedAt(LocalDateTime.now());
        gameRepository.save(game);
        return game;
    }

    public Game checkActiveSession(Player player) {
        return gameRepository
                .findFirstByPlayerIdAndStatusIsOrderByPlayedAtDesc(player.getId(), Status.PLAYING);
    }

    public Game guessTheWord(Game game, String guess) {
        if(game.getGuesses() == null) {
            game.setGuesses(guess);
        } else {
            List<String> guesses = new ArrayList<>(List.of(game.getGuesses().split(",")));
            guesses.add(guess);
            game.setGuesses(String.join(",", guesses));
        }
        if (game.getWord().getValue().equalsIgnoreCase(guess)) {
            game.setStatus(Status.WON);
        } else {
            game.setTriesLeft(game.getTriesLeft() - 1);
            if (game.getTriesLeft() == 0) {
                game.setStatus(Status.LOST);
            }
        }
        gameRepository.save(game);
        return game;
    }

    public Game surrender(Game game) {
        game.setStatus(Status.SURRENDERED);
        gameRepository.save(game);
        return game;
    }

    public int getTotalScore(Player player) {
        return gameRepository.countByPlayerIdAndStatus(player.getId(), Status.WON);
    }
}
