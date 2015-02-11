package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        try{
        FileInputStream reader = new FileInputStream(file1);
        FileOutputStream writer = new FileOutputStream(file2);

        if (reader.available()> 0) {
            byte[] buff = new byte[reader.available()];
            int n = reader.read(buff);
            for (int i = 1; i < buff.length;i = i + 2)
                writer.write(buff[i]);

        }
            in.close();
            reader.close();
            writer.close();
        }
            catch (Exception e){
                e.printStackTrace();
            }


        }

    }

