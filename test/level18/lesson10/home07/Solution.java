package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException {
        int argument = 0;
        if (args.length == 1)
            argument=Integer.parseInt(args[0]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        BufferedReader fileOne = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameOne)));

        String line = fileOne.readLine();
        while (line != null) {
            if (!"".equals(line)) {
                int space = line.indexOf(' ');
                int equals = Integer.parseInt(line.substring(0, space));
                if (equals == argument) {
                    System.out.println(line);

                }
            }
            line = fileOne.readLine();

        }
        fileOne.close();
        reader.close();
    }
}
