package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            String file1 = null;
            String file2 = null;
            if (args.length == 2) {
                file1 = args[0];
                file2 = args[1];

            }
            else {
                file1 = "C:\\new.txt";
                file2 = "C:\\new1.txt";
            }
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
            String s = null;
            boolean first = true;
            while (reader.ready()) {
                s = reader.readLine();
                String[] array = s.split(" ");
               for (String word : array) {
                  if (word.length() > 6) {
                      if ( first ) {
                          writer.write(word);
                          first = false;
                      }
                      else
                      writer.write("," + word);
                  }
                }
             }
reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
