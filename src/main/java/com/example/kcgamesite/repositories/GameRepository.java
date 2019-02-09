package com.example.kcgamesite.repositories;

import com.example.kcgamesite.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
