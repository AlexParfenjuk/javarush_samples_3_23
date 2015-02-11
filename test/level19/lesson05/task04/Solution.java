package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
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
                s = s.replaceAll("\\.","!");
                writer.write(s+"\n");
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
