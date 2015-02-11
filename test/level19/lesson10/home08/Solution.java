package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String file1 = in.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            String s = null;
            while (reader.ready()) {
                s = reader.readLine();
                String res = "";
                StringBuilder stringBuilder = new StringBuilder(s).reverse();

                System.out.println(stringBuilder.toString());
            }
            in.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
