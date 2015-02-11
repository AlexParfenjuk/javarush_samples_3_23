package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException{
        String filename;
        if (args.length > 0)
            filename = args[0];
        else filename = "C:\\new1.txt";


        FileReader in = new FileReader(filename);
        int count = 0;
        boolean isEnglishSymbol;

        while (in.ready()) {
            int symbol = in.read();
            isEnglishSymbol = (symbol >= (int) 'a' && symbol <= (int) 'z') || (symbol >= (int) 'A' && symbol <= (int) 'Z');

            if (isEnglishSymbol)
            count++;
        }

        System.out.println(count);

        in.close();

    }
}
