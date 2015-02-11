package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String file1 = is.readLine();
        String file2 = is.readLine();
        String file3 = is.readLine();

        FileInputStream fi1 = new FileInputStream(file1); //in
        FileOutputStream fi2 = new FileOutputStream(file2); //out
        FileOutputStream fi3 = new FileOutputStream(file3); //out

        int length = fi1.available();
        byte[] ch1 = new byte[length/2];
        byte[] ch2 = new byte[length - ch1.length];

        while (fi1.available() > 0) {
            int count1 = fi1.read(ch1);
            int count2 = fi1.read(ch2);

            fi2.write(ch2, 0, count2);
            fi3.write(ch1, 0, count1);
        }

        is.close();
        fi1.close();
        fi2.close();
        fi3.close();
    }
}
