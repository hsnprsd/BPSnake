package com.hsnprsd.snake.models;

import com.hsnprsd.snake.Config;

import java.util.ArrayList;

public class GameModel {
    private ArrayList<Pixel> apples;
    private Snake snake;
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public Snake getSnake() {
        return snake;
    }

    public GameModel() {
        snake = new Snake();
        player = new Player("Ehsan");
        apples = new ArrayList<Pixel>();
    }

    public char[][] getGrid() {
        int n = Config.n;
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = '.';
            }
        }
        for (int i = 0; i < snake.getPixels().size(); ++i) {
            grid[snake.getPixels().get(i).getX()][snake.getPixels().get(i).getY()] = 'S';
        }
        for (int i = 0; i < apples.size(); ++i) {
            grid[apples.get(i).getX()][apples.get(i).getY()] = 'F';
        }
        grid[snake.getHead().getX()][snake.getHead().getY()] = 'H';
        return grid;
    }

    public boolean moveSnake() {
        Pixel pixel = snake.getHead().move(snake.getDirection());
        for (int i = 0; i < apples.size(); ++i) {
            if (apples.get(i).equals(pixel)) {
                snake.setHead(pixel);
                apples.remove(i);
                return true;
            }
        }
        return snake.nextCycle();
    }

    public void addApple(Pixel apple) {
        apples.add(apple);
    }

    public void setSnakeDirection(int direction) {
        snake.setDirection(direction);
    }

    public boolean isEmpty(Pixel pixel) { // it's ok
        for (int i = 0; i < apples.size(); ++i) {
            if (pixel.equals(apples.get(i))) {
                return false;
            }
        }
        for (int i = 0; i < snake.getPixels().size(); ++i) {
            if (pixel.equals(snake.getPixels().get(i))) {
                return false;
            }
        }
        return true;
    }

    public void init() {
        player.setScore(0);
        snake = new Snake();
        apples = new ArrayList<Pixel>();
    }
}
