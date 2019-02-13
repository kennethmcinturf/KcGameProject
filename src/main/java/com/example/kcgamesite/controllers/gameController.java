package com.example.kcgamesite.controllers;


import com.example.kcgamesite.repositories.GameRepository;
import com.example.kcgamesite.repositories.UserGameRepository;
import com.example.kcgamesite.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class gameController {
    private final GameRepository gameDao;
    private final UserGameRepository usergameDao;
    private final UserRepository userDao;

    public gameController(GameRepository gameDao, UserGameRepository usergameDao, UserRepository userDao) {
        this.gameDao = gameDao;
        this.usergameDao = usergameDao;
        this.userDao = userDao;
    }

    @GetMapping("Tic-Tac-Toe")
    public String ticTacToe() {
        return "Game/Tic-Tac-Toe";
    }
}
