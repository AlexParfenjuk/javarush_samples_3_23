package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    int top;
    int left;
    int width;
    int height;

    public Rectangle(Rectangle obj) {
        this.top = obj.top;
        this.left = obj.left;
        this.width = obj.width;
        this.height = obj.height;

    }

    public Rectangle(int width, int left, int top) {
        this.width = width;
        this.left = left;
        this.top = top;
        height = width;
    }

    public Rectangle(int top, int left) {

        this.top = top;
        this.left = left;
        height = 0;
        width = 0;
    }

    public Rectangle(int top, int left, int width, int height) {

        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

}
