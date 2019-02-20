package com.example.kcgamesite.controllers;

import com.example.kcgamesite.models.User;
import com.example.kcgamesite.models.User_Game;
import com.example.kcgamesite.repositories.GameRepository;
import com.example.kcgamesite.repositories.UserGameRepository;
import com.example.kcgamesite.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class scoreController {
    private final GameRepository gameDao;
    private final UserGameRepository usergameDao;
    private final UserRepository userDao;

    public scoreController(GameRepository gameDao, UserGameRepository usergameDao, UserRepository userDao) {
        this.gameDao = gameDao;
        this.usergameDao = usergameDao;
        this.userDao = userDao;
    }

    private String addScore(String highScore, String game, String URL){
        if (!highScore.equals("") && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser"){
            System.out.println("first hurdele");
            int highScoreNumber = Integer.parseInt(highScore);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User thisUser = userDao.findOne(user.getId());
            User world = userDao.findByUsername("World");
            User_Game thisUserHighScore = usergameDao.findByUserAndGame(thisUser, gameDao.findByTitle(game));
            if (thisUserHighScore == null){
                User_Game user_game = new User_Game();
                user_game.setHighScore(highScoreNumber);
                user_game.setUser(thisUser);
                user_game.setGame(gameDao.findByTitle(game));
                usergameDao.save(user_game);
            }
            if (thisUserHighScore != null && highScoreNumber > thisUserHighScore.getHighScore()){
                if(game.equals("Simple Simon")){
                    thisUserHighScore.setHighScore(highScoreNumber);
                    usergameDao.save(thisUserHighScore);
                }
            }
            if (thisUserHighScore != null && highScoreNumber < thisUserHighScore.getHighScore()){
                if(!game.equals("Simple Simon")){
                        thisUserHighScore.setHighScore(highScoreNumber);
                        usergameDao.save(thisUserHighScore);
                }
            }
            User_Game worldRecord = usergameDao.findByUserAndGame(world, gameDao.findByTitle(game));
            System.out.println(worldRecord.getHighScore());
            if (game.equals("Simple Simon")){
                if (worldRecord.getHighScore() < highScoreNumber || worldRecord.getHighScore() == 0){
                    worldRecord.setHighScorePerson(thisUser);
                    worldRecord.setHighScore(highScoreNumber);
                    usergameDao.save(worldRecord);
                }
            }else {
                if (worldRecord.getHighScore() > highScoreNumber || worldRecord.getHighScore() == 0){
                    worldRecord.setHighScorePerson(thisUser);
                    worldRecord.setHighScore(highScoreNumber);
                    usergameDao.save(worldRecord);
                }
            }
        }
        return URL;
    }

    private void addTicTacToeScore(String game, String title){
        if (!title.equals("") && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser"){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User thisUser = userDao.findOne(user.getId());
            User_Game thisUserHighScore = usergameDao.findByUserAndGame(thisUser, gameDao.findByTitle(game));
            User world = userDao.findByUsername("World");
            User_Game worldRecord = usergameDao.findByUserAndGame(world, gameDao.findByTitle(game));
            if (thisUserHighScore == null){
                User_Game user_game = new User_Game();
                user_game.setHighScore(1);
                worldRecord.setHighScore(worldRecord.getHighScore() + 1);
                user_game.setUser(thisUser);
                user_game.setGame(gameDao.findByTitle(game));
                usergameDao.save(user_game);
                usergameDao.save(worldRecord);
            }else {
                int score = thisUserHighScore.getHighScore();
                score = score + 1;
                thisUserHighScore.setHighScore(score);
                usergameDao.save(thisUserHighScore);
                worldRecord.setHighScore(worldRecord.getHighScore() + 1);
                usergameDao.save(worldRecord);
            }
        }
    }

    @PostMapping("/MemoryCard")
    public String saveMemoryCard(@RequestParam(name = "highScore4") String highScore4, @RequestParam(name = "highScore6") String highScore6,
                                 @RequestParam(name = "highScore8") String highScore8, @RequestParam(name = "highScore10") String highScore10,
                                 @RequestParam(name = "highScore12") String highScore12) {
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

    @PostMapping("/Tic-Tac-Toe")
    public String saveTicTacToe(@RequestParam(name = "X") String highScoreX, @RequestParam(name = "Y") String highScoreY,
                                @RequestParam(name = "SingleWin") String singleWin, @RequestParam(name = "SingleLoss") String singleLoss,
                                @RequestParam(name = "Draw") String draw) {
        addTicTacToeScore("Tic-Tac-Toe X's",highScoreX);
        addTicTacToeScore("Tic-Tac-Toe Y's", highScoreY);
        addTicTacToeScore("Tic-Tac-Toe Win", singleWin);
        addTicTacToeScore("Tic-Tac-Toe Loss", singleLoss);
        addTicTacToeScore("Draw", draw);
        return "Game/Tic-Tac-Toe";
    }
}
