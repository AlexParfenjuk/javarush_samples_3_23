package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            ArrayList<String> filePath = new ArrayList<String>();
            String k;
            while (!"end".equals(k = in.nextLine())) {
                filePath.add(k);
            }
            Collections.sort(filePath);

            BufferedInputStream inputStream;
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(filePath.get(0).substring(0, filePath.get(0).lastIndexOf('.'))));
            for (String s : filePath) {
                inputStream = new BufferedInputStream(new FileInputStream(s));
                byte[] buffer = new byte[inputStream.available()];
                int n = inputStream.read(buffer);
                outputStream.write(buffer);
                inputStream.close();
            }
            outputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
       in.close();
    }
}
