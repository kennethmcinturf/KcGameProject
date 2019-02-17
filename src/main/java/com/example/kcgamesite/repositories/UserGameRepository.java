package com.example.kcgamesite.repositories;

import com.example.kcgamesite.models.Game;
import com.example.kcgamesite.models.User;
import com.example.kcgamesite.models.User_Game;
import org.springframework.data.repository.CrudRepository;

public interface UserGameRepository extends CrudRepository<User_Game, Long> {
    User_Game findByUserAndGame(User user, Game game);
}