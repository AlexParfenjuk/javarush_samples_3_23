package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.TreeMap;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0) {
            int cur = fileInputStream.read();
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        int maxpovt = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
        if (entry.getValue() > maxpovt)
            maxpovt = entry.getValue();
        }



        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == maxpovt)
            System.out.print(entry.getKey() + " ");
        }
        reader.close();
        fileInputStream.close();
    }
}
