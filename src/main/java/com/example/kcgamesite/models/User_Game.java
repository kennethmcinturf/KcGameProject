package com.example.kcgamesite.models;

import javax.persistence.*;

@Entity
@Table(name = "User_Game")
public class User_Game {
    @Id @GeneratedValue
    private long id;

    @Column
    private int highScore;

    @ManyToOne
    @JoinColumn (name = "game_id")
    private Game game;

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
