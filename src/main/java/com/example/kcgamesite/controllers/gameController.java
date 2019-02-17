package com.example.kcgamesite.controllers;


import com.example.kcgamesite.models.Game;
import com.example.kcgamesite.models.User;
import com.example.kcgamesite.models.User_Game;
import com.example.kcgamesite.repositories.GameRepository;
import com.example.kcgamesite.repositories.UserGameRepository;
import com.example.kcgamesite.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/Tic-Tac-Toe")
    public String ticTacToe() {
        if (gameDao.findByTitle("Tic-Tac-Toe") == null){
            Game game = new Game();
            game.setTitle("Tic-Tac-Toe");
            gameDao.save(game);
        }
        return "Game/Tic-Tac-Toe";
    }

    @GetMapping("/MemoryCard")
    public String memoryCard() {
        if (gameDao.findByTitle("Memory Card 4") == null){
            Game mem4 = new Game();
            mem4.setTitle("Memory Card 4");
            Game mem6 = new Game();
            mem4.setTitle("Memory Card 6");
            Game mem8 = new Game();
            mem4.setTitle("Memory Card 8");
            Game mem10 = new Game();
            mem4.setTitle("Memory Card 10");
            Game mem12 = new Game();
            mem4.setTitle("Memory Card 12");
            gameDao.save(mem4);
            gameDao.save(mem6);
            gameDao.save(mem8);
            gameDao.save(mem10);
            gameDao.save(mem12);
        }
        return "Game/Memory_Card";
    }

    @GetMapping("/SimpleSimon")
    public String simpleSimon() {
        if (gameDao.findByTitle("Simple Simon") == null){
            Game game = new Game();
            game.setTitle("Simple Simon");
            gameDao.save(game);
        }
        return "Game/Simple_Simon";
    }

    @PostMapping("/SimpleSimon")
    public String saveSimpleSimon(@RequestParam(name = "highScore") String highScore) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        System.out.println(highScore);
        if (highScore != null && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser"){
            int highScoreNumber = Integer.parseInt(highScore);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User thisUser = userDao.findOne(user.getId());
            User_Game thisUserHighScore = usergameDao.findByUserAndGame(thisUser, gameDao.findByTitle("Simple Simon"));
            if (thisUserHighScore == null){
                System.out.println("got here");
                User_Game user_game = new User_Game();
                user_game.setHighScore(highScoreNumber);
                user_game.setUser(thisUser);
                user_game.setGame(gameDao.findByTitle("Simple Simon"));
                usergameDao.save(user_game);
                return "Game/Simple_Simon";
            }
            if (highScoreNumber > thisUserHighScore.getHighScore()){
                System.out.println("No, it got here");
                thisUserHighScore.setHighScore(highScoreNumber);
                usergameDao.save(thisUserHighScore);
                return "Game/Simple_Simon";
            }
        }
        return "Game/Simple_Simon";
    }
}
