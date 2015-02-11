package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filename = null;
        try {
            while (true) {
                filename = in.nextLine();
                if (filename == null) break;
                FileInputStream fileInputStream = new FileInputStream(filename);
                fileInputStream.close();
            }
         }
        catch (FileNotFoundException e) {
            System.out.println(filename);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        in.close();
    }
}
