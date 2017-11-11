package com.hsnprsd.snake.views;

import com.hsnprsd.snake.Config;
import com.hsnprsd.snake.models.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameView extends JFrame {
    JButton[][] grid;
    private GameModel gameModel;
    private KeyListener keyListener;

    public GameView(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void showGrid() {
        int n = Config.n;
        int m = Config.m;
        char[][] grid = gameModel.getGrid();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '.') {
                    this.grid[i][j].setBackground(Color.WHITE);
                } else if (grid[i][j] == 'S') {
                    this.grid[i][j].setBackground(Color.YELLOW);
                } else if (grid[i][j] == 'H') {
                    this.grid[i][j].setBackground(Color.ORANGE);
                } else {
                    this.grid[i][j].setBackground(Color.RED);
                }
            }
        }
        revalidate();
        repaint();
    }

    public void init() {
        getContentPane().removeAll();
        setTitle("Snake");
        setSize(640, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        setLayout(new GridLayout(Config.n, Config.m));
        int n = Config.n;
        int m = Config.m;
        grid = new JButton[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                JButton button = new JButton();
                button.setFocusable(false);
                button.setBackground(Color.WHITE);
                button.setBorderPainted(false);
                grid[i][j] = button;
                getContentPane().add(grid[i][j]);
            }
        }
        removeKeyListener(keyListener);
        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_W:
                        gameModel.setSnakeDirection(0);
                        break;
                    case KeyEvent.VK_UP:
                        gameModel.setSnakeDirection(0);
                        break;
                    case KeyEvent.VK_S:
                        gameModel.setSnakeDirection(1);
                        break;
                    case KeyEvent.VK_DOWN:
                        gameModel.setSnakeDirection(1);
                        break;
                    case KeyEvent.VK_A:
                        gameModel.setSnakeDirection(2);
                        break;
                    case KeyEvent.VK_LEFT:
                        gameModel.setSnakeDirection(2);
                        break;
                    case KeyEvent.VK_D:
                        gameModel.setSnakeDirection(3);
                        break;
                    case KeyEvent.VK_RIGHT:
                        gameModel.setSnakeDirection(3);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        };
        addKeyListener(keyListener);
        setVisible(true);
    }
}
