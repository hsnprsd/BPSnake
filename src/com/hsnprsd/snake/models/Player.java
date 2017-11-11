package com.hsnprsd.snake.models;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        name = "Guest";
    }

    public void addScore() {
        score += 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
