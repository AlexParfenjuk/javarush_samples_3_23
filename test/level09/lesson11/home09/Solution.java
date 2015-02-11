package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //Напишите тут ваш код
        Map<String,Cat> map= new HashMap<String,Cat>();
        map.put("Jeer",new Cat("Jeer"));
        map.put("Beer",new Cat("Beer"));
        map.put("Fear",new Cat("Fear"));
        map.put("Meer",new Cat("Meer"));
        map.put("Neer",new Cat("Neer"));
        map.put("iCat",new Cat("iCat"));
        map.put("Weer",new Cat("Weer"));
        map.put("Android",new Cat("Android"));
        map.put("Waas",new Cat("Waas"));
        map.put("Bass",new Cat("Bass"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //Напишите тут ваш код
        Set<Cat> cats = new HashSet<Cat>(map.values());
        return  cats;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
