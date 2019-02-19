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
            mem6.setTitle("Memory Card 6");
            Game mem8 = new Game();
            mem8.setTitle("Memory Card 8");
            Game mem10 = new Game();
            mem10.setTitle("Memory Card 10");
            Game mem12 = new Game();
            mem12.setTitle("Memory Card 12");
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

    private String addScore(String highScore, String game, String URL){
        System.out.println("whats up");
        if (!highScore.equals("") && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser"){
            System.out.println("first hurdele");
            int highScoreNumber = Integer.parseInt(highScore);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User thisUser = userDao.findOne(user.getId());
            User_Game thisUserHighScore = usergameDao.findByUserAndGame(thisUser, gameDao.findByTitle(game));
            if (thisUserHighScore == null){
                System.out.println("got here");
                User_Game user_game = new User_Game();
                user_game.setHighScore(highScoreNumber);
                user_game.setUser(thisUser);
                user_game.setGame(gameDao.findByTitle(game));
                usergameDao.save(user_game);
                return URL;
            }
            if (highScoreNumber > thisUserHighScore.getHighScore()){
                System.out.println("No, it got here");
                thisUserHighScore.setHighScore(highScoreNumber);
                usergameDao.save(thisUserHighScore);
                return URL;
            }
        }
        return URL;
    }

    @PostMapping("/MemoryCard")
    public String saveMemoryCard(@RequestParam(name = "highScore4") String highScore4, @RequestParam(name = "highScore6") String highScore6,
                                 @RequestParam(name = "highScore8") String highScore8, @RequestParam(name = "highScore10") String highScore10,
                                 @RequestParam(name = "highScore12") String highScore12) {
        System.out.println("hey");
        addScore(highScore4, "Memory Card 4", "none");
        addScore(highScore6, "Memory Card 6", "none");
        addScore(highScore8, "Memory Card 8", "none");
        addScore(highScore10, "Memory Card 10", "none");
        addScore(highScore12, "Memory Card 12", "none");
        return "Game/Memory_Card";
    }

    @PostMapping("/SimpleSimon")
    public String saveSimpleSimon(@RequestParam(name = "highScore") String highScore) {
        return addScore(highScore, "Simple Simon", "Game/Simple_Simon");
    }
}
