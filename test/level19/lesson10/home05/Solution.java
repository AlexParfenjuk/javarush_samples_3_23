package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String file1= null;
            String file2 = null;
            if (args.length == 2) {
                file1 = args[0];
                file2 = args[1];
            }
            else {
                file1 = "C:\\new.txt";
                file2 = "C:\\new1.txt";
            }

            BufferedReader reader = new BufferedReader(new FileReader(file1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

            String s = null;
            while (reader.ready()) {
                s = reader.readLine();
                String[] array = s.split(" ");
                String itog = "";
                for (String word : array) {
                    if(  word.matches("[\\D]*?[\\d]+[\\D]*?")    )
                     itog += word + " ";
               }
                itog = itog.trim();
                writer.write(itog);

            }
            reader.close();
            writer.close();
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
