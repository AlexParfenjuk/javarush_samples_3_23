package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Roodie on 24.08.2014.
 */
public class Field {

    private int width;
    private int height;
    private int[][] matrix;



    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void print() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if (matrix[i][j] == 0) {
                    System.out.print(".");

                } else System.out.print("X");
            }
            System.out.println();
        }
    }


    public void removeFullLines() {}

    public Integer getValue (int x,int y) {
       return matrix[y][x];

    }
    void setValue(int x, int y, int value) {

            matrix[y][x] = value;


    }


}
