package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        in.close();

        try {
            in = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e) {
            return;
        }
        //...
        if (!in.hasNext())
            return;
        StringBuilder result = getLine(in.nextLine().split(" "));
        System.out.println(result.toString());
        in.close();
    }

    public static StringBuilder getLine(String... words) {
        //защита от BOM в UTF-8
        if (words == null) return  new StringBuilder();
        if (words.length == 0) return  new StringBuilder();
        if (words[0].charAt(0) == (char)65279)
            words[0] = words[0].substring(1);

        //для пущей надёжности пробую составить цепочку, начиная с каждого слова
        for (int j = 0; j < words.length; j++) {

            //тут будут все слова.
            //те, которые уже вошли в цепочку, отсюда будем удалять
            ArrayList<String> data = new ArrayList<>();

            for (String word : words)
                data.add(word);

            StringBuilder result = new StringBuilder();

            result.append(data.get(j));
            data.remove(j);


            while (data.isEmpty() == false) {
                String temporaryResult = result.toString().toLowerCase();
                int dataSize = data.size();

                //пробуем добавить к цепочке одно слово
                for (int i = 0; i < data.size(); i++) {
                    String word = data.get(i).toLowerCase();
                    if (word.charAt(0) == temporaryResult.charAt(temporaryResult.length() - 1)) {
                        result.append(" ");
                        result.append(data.get(i));
                        data.remove(i);
                        break;
                    }
                    if (word.charAt(word.length() - 1) == temporaryResult.charAt(0)) {
                        result.insert(0, " ");
                        result.insert(0, data.get(i));
                        data.remove(i);
                        break;
                    }
                }

                //если длина цепочки не поменялась, значит
                //составить цепочку не получится
                //выходим из цикла и начинаем заново, с другого слова
                if (dataSize == data.size())
                    break;
            }
            if (data.size() == 0) {
                return result;
            }
        }
        return new StringBuilder();
    }

}
