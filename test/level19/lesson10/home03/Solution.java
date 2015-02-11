package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

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
                String[] array = s.split(" ");
                String name = "";
                int
                        day = 0,
                        month = 0,
                        year = 0;

                if (array.length > 4) {

                    for (int i = 0; i < (array.length - 3); i++)
                        name += array[i] + " ";
                    name = name.trim();
                    day = Integer.parseInt(array[array.length - 3]);
                    month = Integer.parseInt(array[array.length - 2]);
                    year = Integer.parseInt(array[array.length - 1]);
                } else {
                    name = array[0];
                    day = Integer.parseInt(array[1]);
                    month = Integer.parseInt(array[2]);
                    year = Integer.parseInt(array[3]);
                }
                Calendar date = new GregorianCalendar(year, month - 1, day);
                Date Currentdate = date.getTime();
                Person person = new Person(name,Currentdate);
                PEOPLE.add(person);


            }


                reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
