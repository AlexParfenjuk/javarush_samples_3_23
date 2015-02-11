package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        LinkedList<String> date = new LinkedList<String>();
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader reader = new BufferedReader(fileReader)
        )
        {
            while (reader.ready())
            {
                for(String s: reader.readLine().split(" ")){
                    date.add(s);
                }
            }
        }
        catch (Exception e)
        {}
        while(!date.isEmpty()){
            String word = date.poll();
            StringBuilder sb = new StringBuilder(word);

            String reverse = sb.reverse().toString();
            if ( date.contains(reverse) )
            {
                Pair pair = new Pair();
                pair.first = word;
                pair.second = reverse;
                result.add(pair);
                date.remove(reverse);
            }
        }
        for(Pair pair : result)
        System.out.println(pair);




    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
