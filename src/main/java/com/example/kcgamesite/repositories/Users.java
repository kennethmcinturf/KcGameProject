package com.example.kcgamesite.repositories;

import com.example.kcgamesite.models.User;
import org.springframework.data.repository.CrudRepository;


public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
