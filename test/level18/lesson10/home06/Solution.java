package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        String filename;
        if (args.length > 0)
            filename = args[0];
        else filename = "C:\\new1.txt";
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        FileInputStream fileInputStream = new FileInputStream(filename);
        while (fileInputStream.available() > 0) {
            char cur = (char)fileInputStream.read();
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        for (Map.Entry<Character,Integer> entry : map.entrySet()){
              System.out.println(entry.getKey() + " " + entry.getValue());
        }

        fileInputStream.close();

    }
}
