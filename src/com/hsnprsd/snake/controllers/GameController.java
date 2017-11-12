package com.hsnprsd.snake.controllers;

import com.hsnprsd.snake.Config;
import com.hsnprsd.snake.models.*;
import com.hsnprsd.snake.views.GameView;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameModel gameModel, GameView gameView) {
        this.gameModel = gameModel;
        this.gameView = gameView;
    }

    public void createApple() {
        int n = Config.n;
        int r = (int) (Math.random() * n * n);
        if (gameModel.isEmpty(new Pixel(r / n, r % n))) {
            gameModel.addApple(new Pixel(r / n, r % n));
        }
    }

    public void init() {
        gameModel.init();
        gameView.init();
    }

    public void startGame() throws InterruptedException {
        init();
        int currentCycle = 0;
        boolean isGameEnded = false;
        while (!isGameEnded) {
            gameView.showGrid();
            if (currentCycle % Config.cyclesPerApple == 0) {
                createApple();
            }
            if (currentCycle % Config.cyclesPerMove == 0) {
                if (gameModel.moveSnake() == false) {
                    int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "?",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) {
                    	isGameEnded = true;
                    } else if (response == JOptionPane.YES_OPTION) {
                        startGame();
                    }
                }
            }
            TimeUnit.MILLISECONDS.sleep(10);
            ++currentCycle;
        }
    }
}
