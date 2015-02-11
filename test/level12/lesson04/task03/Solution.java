package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public static void print(int n) {
        System.out.println("int "+ n);}
    public static void print (Integer n) {
        System.out.println("Integer " + n);}
    public static void print (boolean b) {}
    public static void print (String s) {}
    public static void print (long l) {}
}
