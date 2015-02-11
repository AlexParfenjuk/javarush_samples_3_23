package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        int count = 0;
        while (fileInputStream.available() > 0 ) {
            int n = fileInputStream.read();
            if (n == 44)
                count++;
        }
        System.out.println(count);
        scanner.close();
        fileInputStream.close();
    }
}
