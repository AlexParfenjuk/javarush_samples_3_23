package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args)throws IOException {
        String filename;
        if (args.length > 0)
            filename = args[0];
        else filename = "D:\\Business_English.doc";
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
        int countAll = dis.available();
        int countSpace = 0;
        while (dis.available() > 0) {
            String s = dis.readLine();
            String[] data = s.split("");
            for (String x : data)
            {
                if (x.equals(" "))
                    countSpace++;
            }
        }
        double dCountSpace = (double) countSpace;
        double dCountAll = (double) countAll;
        double c = (dCountSpace/dCountAll) * 100;

        System.out.printf("%.2f",c);

        dis.close();
        fis.close();
        bis.close();
    }
}
