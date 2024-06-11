package com.johncarlo.guessinggame.controller;

import com.johncarlo.guessinggame.model.Player;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/")
    public String index(HttpSession httpSession) {
        if (httpSession.getAttribute("player") == null) {
            return "redirect:/player/login";
        } else {
            return "redirect:/game/start";
        }
    }

    @GetMapping("/player/signup")
    public String signup(Model model) {
        model.addAttribute("player", new Player());
        return "signup";
    }

    @PostMapping("/player/signup")
    public String signup(@ModelAttribute Player player, Model model) {
        String error = playerService.signupPlayer(player);
        if (error != null) {
            model.addAttribute("player", player);
            model.addAttribute("error", error);
            return "signup";
        } else {
            return "redirect:/player/login";
        }
    }

    @GetMapping("/player/login")
    public String login(Model model) {
        model.addAttribute("player", new Player());
        return "login";
    }

    @PostMapping("/player/login")
    public String login(@ModelAttribute Player player, HttpSession httpSession, Model model) {
        Player validPlayer = playerService.login(player);
        if (validPlayer == null) {
            model.addAttribute("player", player);
            model.addAttribute("error", true);
            return "login";
        } else {
            httpSession.setAttribute("player", validPlayer);
            return "redirect:/game/start";
        }
    }

    @PostMapping("/player/logout")
    public String logoutPost(HttpSession httpSession) {
        httpSession.removeAttribute("player");
        httpSession.removeAttribute("game");
        return "redirect:/player/login";
    }

    @GetMapping("/player/logout")
    public String logoutGet(HttpSession httpSession) {
        httpSession.removeAttribute("player");
        httpSession.removeAttribute("game");
        return "redirect:/player/login";
    }

}
