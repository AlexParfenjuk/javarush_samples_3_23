package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException,FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();

        RandomAccessFile fileOne = new RandomAccessFile(fileNameOne, "r");
        RandomAccessFile fileTwo = new RandomAccessFile(fileNameTwo, "rw");

        String s;
            while (true) {
                s = fileOne.readLine();
                if (s == null) break;
                String[] tmp = s.split(" ");
                for (String item :tmp) {
                    int i = (int) Math.round(Double.parseDouble(item));
                    fileTwo.writeBytes(String.valueOf(i)+" ");
                }
             }

        fileOne.close();
        fileTwo.close();
        reader.close();

    }
}
