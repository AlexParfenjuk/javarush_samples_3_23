package com.javarush.test.level06.lesson08.task05;

/* Класс StringHelper
Cделать класс StringHelper, у которого будут 2 статических метода:
String multiply(String s, int count) – возвращает строку повторенную count раз.
String multiply(String s) – возвращает строку повторенную 5 раз.
Пример:
Амиго -> АмигоАмигоАмигоАмигоАмиго
*/

public class StringHelper
{
    public static String multiply(String s)
    {

        //Напишите тут ваш код
        return multiply(s,5);
    }

    public static String multiply(String s, int count)
    {
        StringBuffer buffer = new StringBuffer( 25 );

        for ( int i = 0; i < count; i++ )
        {
            buffer.append( s );
        }

        return buffer.toString();
    }
}
