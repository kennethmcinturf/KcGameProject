package com.example.kcgamesite.controllers;


import com.example.kcgamesite.models.Game;
import com.example.kcgamesite.models.User;
import com.example.kcgamesite.models.User_Game;
import com.example.kcgamesite.repositories.GameRepository;
import com.example.kcgamesite.repositories.UserGameRepository;
import com.example.kcgamesite.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
        if (gameDao.findByTitle("Tic-Tac-Toe X's") == null){
            Game gameX = new Game();
            gameX.setTitle("Tic-Tac-Toe X's");
            Game gameY = new Game();
            gameY.setTitle("Tic-Tac-Toe Y's");
            Game gameWin = new Game();
            gameWin.setTitle("Tic-Tac-Toe Win");
            Game gameLoss = new Game();
            gameLoss.setTitle("Tic-Tac-Toe Loss");
            gameDao.save(gameX);
            gameDao.save(gameY);
            gameDao.save(gameWin);
            gameDao.save(gameLoss);
            User world = userDao.findByUsername("World");
            User_Game worldGame1 = new User_Game(0, gameX, world);
            usergameDao.save(worldGame1);
            User_Game worldGame2 = new User_Game(0, gameY, world);
            usergameDao.save(worldGame2);
            User_Game worldGame3 = new User_Game(0, gameWin, world);
            usergameDao.save(worldGame3);
            User_Game worldGame4 = new User_Game(0, gameLoss, world);
            usergameDao.save(worldGame4);
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
            User world = userDao.findByUsername("World");
            User_Game worldGame1 = new User_Game(0, mem4, world);
            usergameDao.save(worldGame1);
            User_Game worldGame2 = new User_Game(0, mem6, world);
            usergameDao.save(worldGame2);
            User_Game worldGame3 = new User_Game(0, mem8, world);
            usergameDao.save(worldGame3);
            User_Game worldGame4 = new User_Game(0, mem10, world);
            usergameDao.save(worldGame4);
            User_Game worldGame5 = new User_Game(0, mem12, world);
            usergameDao.save(worldGame5);
        }
        return "Game/Memory_Card";
    }

    @GetMapping("/SimpleSimon")
    public String simpleSimon() {
        if (gameDao.findByTitle("Simple Simon") == null){
            Game game = new Game();
            game.setTitle("Simple Simon");
            gameDao.save(game);
            User world = userDao.findByUsername("World");
            User_Game worldGame = new User_Game(0, game, world);
            usergameDao.save(worldGame);
        }
        return "Game/Simple_Simon";
    }
}
