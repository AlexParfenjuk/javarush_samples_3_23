package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        if (string == null) throw new TooShortStringException();
       String s1;
        char[] chars = string.toCharArray();
        int countTab = 0;
        for (char ch : chars)
        {
            if (ch == '\t')
            {
                countTab++;
            }
        }
        String result;
        if (countTab < 2)
        {
            throw new TooShortStringException();
        } else
        {
            int f1 = string.indexOf('\t');
            int f2 = string.indexOf('\t',f1+1);
            s1 = string.substring(f1+1,f2);
            result = s1;
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

}
