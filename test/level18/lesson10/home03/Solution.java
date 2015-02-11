package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException,FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        String file3 = in.nextLine();
        FileInputStream inputStream1 = new FileInputStream(file2);
        FileInputStream inputStream2 = new FileInputStream(file3);
        FileOutputStream outputStream = new FileOutputStream(file1);
        byte[] buff = new byte[inputStream1.available()];
        int count = inputStream1.read(buff);
        outputStream.write(buff);
        buff = new byte[inputStream2.available()];
        count = inputStream2.read(buff);
        outputStream.write(buff);
        in.close();
        inputStream1.close();
        inputStream2.close();
        outputStream.close();



    }
}
