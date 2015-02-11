package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static TreeMap<String,Double> treeMap = new TreeMap<String, Double>();
    public static void main(String[] args) {
        try {
            String file = null;
            if (args.length == 1)
                file = args[0];
            else
                file = "C:\\new.txt";
            String s = null;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                s = reader.readLine();
                String name = s.substring(0,s.indexOf(' '));
                double value = Double.parseDouble(s.substring(s.indexOf(' ')+1));
                if (treeMap.containsKey(name))
                    treeMap.put(name,treeMap.get(name)+value);
                else
                    treeMap.put(name,value);
            }
            double maxvalue = 0;
            for (Map.Entry<String,Double> entry : treeMap.entrySet()){
              if (entry.getValue() > maxvalue)
                  maxvalue = entry.getValue();
            }
            for (Map.Entry<String,Double> entry : treeMap.entrySet()) {
                if (entry.getValue() == maxvalue)
                    System.out.println(entry.getKey());
            }
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
