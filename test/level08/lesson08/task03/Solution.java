package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String,String> people = new HashMap<String, String>();
        people.put("Ivanov", "Petr");
        people.put("Petrov", "Vasilij");
        people.put("Sidorov", "Sergey");
        people.put("Smirnov", "Pyotr");
        people.put("Nemiroff", "Vasilij");
        people.put("Ivanova", "Sofia");
        people.put("Macalan", "John");
        people.put("Smirnoff", "Vovochka");
        people.put("Jameson", "John");
        people.put("Napoleone", "Buonaparte");

        return people;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        int count = 0;
        for(Map.Entry<String,String> entry : map.entrySet())
        {
            String nm = entry.getValue();
            if (name.equals(nm)) count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        int count = 0;
        for(Map.Entry<String,String> entry : map.entrySet())
        {
            String nm = entry.getKey();
            if (familiya.equals(nm)) count++;
        }
        return count;

    }
}
