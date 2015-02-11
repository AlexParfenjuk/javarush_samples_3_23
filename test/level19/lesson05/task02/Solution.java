package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    final static String WORD = "world";
    static Pattern pattern = Pattern.compile(WORD);

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String file = in.nextLine();
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (true) {
                String s = reader.readLine();
                if (s == null) break;
                list.add(s);
            }
            int count = 0;
            for (String str : list) {
                Matcher matcher = pattern.matcher(str);
                while (matcher.find()) {
                    count++;
                }
            }
            System.out.println(count);
            in.close();
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


