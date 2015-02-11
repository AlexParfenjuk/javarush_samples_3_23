package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        FileWriter outputStream = new FileWriter(filename);
        String s = "";

        while (!"exit".equals(s))
        {
            s = br.readLine();
            outputStream.write(s+"\r\n");

        }
        outputStream.close();
        br.close();
    }
}
