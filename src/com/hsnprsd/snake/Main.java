package com.hsnprsd.snake;

import com.hsnprsd.snake.controllers.GameController;
import com.hsnprsd.snake.models.GameModel;
import com.hsnprsd.snake.views.GameView;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameModel gameModel = new GameModel();
        GameView gameView = new GameView(gameModel);
        GameController gameController = new GameController(gameModel, gameView);
        gameController.startGame();
        gameView.setVisible(false);
        gameView.dispose();
    }
}
