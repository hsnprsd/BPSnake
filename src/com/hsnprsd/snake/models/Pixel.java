package com.hsnprsd.snake.models;

import com.hsnprsd.snake.Config;

public class Pixel {
    private int x, y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Pixel move(int direction) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = Config.n;
        return new Pixel((x + dx[direction] + n) % n, (y + dy[direction] + n) % n);
    }

    public boolean equals(Pixel pixel) {
        return pixel.getX() == x && pixel.getY() == y;
    }
}
