package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String file1 = in.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            String s = null;
            while (reader.ready()) {
                s = reader.readLine();
                int count = 0;
                for (String word : words) {
                    if (s.contains(word))
                        count++;
                }
                if (count == 2)
                    System.out.println(s);
            }
            in.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
