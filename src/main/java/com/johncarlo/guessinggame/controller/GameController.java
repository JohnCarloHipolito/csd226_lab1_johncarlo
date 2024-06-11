package com.johncarlo.guessinggame.controller;

import com.johncarlo.guessinggame.model.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/game/start")
    public String startGame(HttpSession httpSession) {
        Game game = gameService.checkActiveSession((Player) httpSession.getAttribute("player"));
        if (game != null) {
            httpSession.setAttribute("game", game);
            return "redirect:/game/guess";
        } else {
            return "start";
        }
    }

    @PostMapping("/game/start")
    public String startGame(HttpSession httpSession, @RequestParam Level level) {
        Game game = gameService.startGame((Player) httpSession.getAttribute("player"), level);
        httpSession.setAttribute("game", game);
        return "redirect:/game/guess";
    }

    @GetMapping("/game/guess")
    public String guess(HttpSession httpSession, Model model) {
        model.addAttribute("game", httpSession.getAttribute("game"));
        return "guess";
    }

    @PostMapping(value="/game/guess")
    public String guess(HttpSession httpSession, @RequestParam String guess) {
        Game game = gameService.guessTheWord((Game) httpSession.getAttribute("game"), guess);
        if (game.getStatus() == Status.PLAYING) {
            httpSession.setAttribute("game", game);
            return "redirect:/game/guess";
        } else {
            return "redirect:/game/end";
        }
    }

    @PostMapping("/game/surrender")
    public String surrender(HttpSession httpSession) {
        Game game = gameService.surrender((Game) httpSession.getAttribute("game"));
        httpSession.setAttribute("game", game);
        return "redirect:/game/end";
    }

    @GetMapping("/game/end")
    public String endGame(HttpSession httpSession, Model model) {
        model.addAttribute("status", httpSession.getAttribute("game"));
        model.addAttribute("game", httpSession.getAttribute("game"));
        httpSession.removeAttribute("game");
        int totalScore = gameService.getTotalScore((Player) httpSession.getAttribute("player"));
        model.addAttribute("totalScore", totalScore);
        return "end";
    }
}