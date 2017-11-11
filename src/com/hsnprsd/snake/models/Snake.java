package com.hsnprsd.snake.models;

import com.hsnprsd.snake.Config;

import java.util.ArrayList;

public class Snake {
    private ArrayList<Pixel> pixels;
    private int direction = 1;

    public Snake() {
        pixels = new ArrayList<Pixel>();
        pixels.add(new Pixel(0, 0));
    }

    public ArrayList<Pixel> getPixels() {
        return pixels;
    }

    public boolean nextCycle() {
        setHead(getHead().move(direction));
        remTail();
        for (int i = 0; i < pixels.size(); ++i) {
            for (int j = i + 1; j < pixels.size(); ++j) {
                if (pixels.get(i).equals(pixels.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public Pixel getHead() {
        return pixels.get(0);
    }

    public void setHead(Pixel head) {
        pixels.add(0, head);
    }

    public void remTail() {
        if (pixels.size() > 0) {
            pixels.remove(pixels.size() - 1);
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
