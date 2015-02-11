package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String filename = br.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Integer> list = new ArrayList<Integer>();
        String line = null;
        int number;
        while ((line = reader.readLine()) != null) {
            String []str = line.trim().split("\\s");
            for (String s : str) {
                try {
                    number = Integer.parseInt(s);
                    list.add(number);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        reader.close();

        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0)
                System.out.println(array[i]);

        }

    }
}
