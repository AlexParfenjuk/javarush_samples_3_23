package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //Напишите тут ваш код
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i <s.length(); i++) {
            list.add(s.charAt(i));

        }

        for (int i = 0; i <list.size() ; i++) {
           for (Character c : list)
               System.out.print(c);
            System.out.println();
            list.remove(0);

       }
    }

}
