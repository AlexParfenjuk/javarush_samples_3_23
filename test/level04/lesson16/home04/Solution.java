package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int y = Integer.parseInt(s1);
        int m = Integer.parseInt(s2);
        int d = Integer.parseInt(s3);
        System.out.println("Меня зовут "+name);
        System.out.println("Я родился "+d+"."+m+"."+y);
    }
}
