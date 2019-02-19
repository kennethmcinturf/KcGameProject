package com.example.kcgamesite.models;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id @GeneratedValue
    private long id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @OneToOne
    private User_Game user_game;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
        user_game = copy.user_game;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User_Game getUser_game() {
        return user_game;
    }

    public void setUser_game(User_Game user_game) {
        this.user_game = user_game;
    }
}
