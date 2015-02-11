package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) {
        String[] arguments = new String[3];
        if (args.length > 1) {
            arguments = args;
        } else {
            arguments[0] = "-d";
            arguments[2] = "C:\\fon2.png";
            arguments[1] = "C:\\fon1.bmp";
        }
        boolean znak;
        if ("-e".equals(arguments[0]))
                znak = true;
        else znak =false;
        try {
            FileInputStream fileInputStream = new FileInputStream(arguments[1]);
            FileOutputStream outputStream = new FileOutputStream(arguments[2]);
            if (fileInputStream.available() > 0) {
                byte[] buff = new byte[fileInputStream.available()];
                int n = fileInputStream.read(buff);
                shifrovanie(znak, buff);
                outputStream.write(buff);
            }
            fileInputStream.close();
            outputStream.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


        public static void shifrovanie(boolean yield,byte[] buffer) {
            for(int i = 0;i < buffer.length;i++){
                if (yield)
                    buffer[i]--;
                else
                    buffer[i]++;
            }
        }




}
