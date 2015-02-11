package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String file1 = in.nextLine();
            String file2 = in.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader(file1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

            String s = null;
            while (reader.ready()) {
                s = reader.readLine();
                String[] array = s.split(" ");
                for (String x : array) {
                    try {
                        int number = Integer.parseInt(x);
                        writer.write(x+" ");
                    } catch (Exception e) {

                    }
                }

            }
            reader.close();
            writer.close();
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
