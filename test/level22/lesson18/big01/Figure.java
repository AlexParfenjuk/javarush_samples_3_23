package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Roodie on 24.08.2014.
 */
public class Figure {
    int x;
    int y;
    int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    void up(){}

    void left (){}

    void right () {}

    void down () {}

    void downMaximum () {}

    boolean isCurrentPositionAvailable () {
        return true;
    }

    void landed () {}

    void rotate () {}
}
