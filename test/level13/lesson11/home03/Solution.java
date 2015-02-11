package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stpath = br.readLine();
        InputStream inStream = new FileInputStream(stpath);
        while (inStream.available() > 0)
        {

            System.out.print((char)inStream.read());
        }
        inStream.close();
        br.close();
    }
}
