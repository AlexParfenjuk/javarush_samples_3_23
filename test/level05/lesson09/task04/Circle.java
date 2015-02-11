package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius  width, color
*/

public class Circle
{
    //Напишите тут ваш код
    int CenterX;
    int CenterY;
    int radius;
    int width;
    int color;

    public Circle(int centerX, int centerY, int radius, int width, int color) {
        CenterX = centerX;
        CenterY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }

    public Circle(int centerX, int centerY, int radius, int width) {

        CenterX = centerX;
        CenterY = centerY;
        this.radius = radius;
        this.width = width;
    }

    public Circle(int centerX, int centerY, int radius) {

        CenterX = centerX;
        CenterY = centerY;
        this.radius = radius;
    }
}
