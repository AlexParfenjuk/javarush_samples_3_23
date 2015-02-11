package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 12 2012".
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        //Напишите тут ваш код
        //Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        //cal.setTime(date);
        DateFormat format1 = new SimpleDateFormat("dd MM yyyy");
        //int year = cal.get(Calendar.YEAR);
        //int month = cal.get(Calendar.MONTH)+1;
        //int day = cal.get(Calendar.DAY_OF_MONTH);

        String date = format1.format(cal.getTime());
        System.out.println(cal);
    }
}
