package com.example.kcgamesite.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Game")
public class Game {
    @Id @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany
    private List<User_Game> user_games;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User_Game> getUser_games() {
        return user_games;
    }

    public void setUser_games(List<User_Game> user_games) {
        this.user_games = user_games;
    }
}
