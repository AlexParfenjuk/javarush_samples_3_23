package com.javarush.test.level14.lesson08.bonus01;

import java.io.CharConversionException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        for (int j = 0; j < 10; j++){
            try
            {
                float i = 1 / 0;

            } catch (Exception e)
            {
                exceptions.add(e);
            }
        }

    }
}
