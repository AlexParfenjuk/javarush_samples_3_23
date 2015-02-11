package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String filename1 = scanner.nextLine();
        String filename2 = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream(filename1);
        FileOutputStream fileOutputStream = new FileOutputStream(filename2);
        byte[]  buffer = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0 ) {
            int count = fileInputStream.read(buffer);
        }
        for (int i = buffer.length-1;i >=0;i--)
            fileOutputStream.write(buffer[i]);


        scanner.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
