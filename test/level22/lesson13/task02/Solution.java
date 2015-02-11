package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в
кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    static Charset Wind  = Charset.forName("Windows-1251");
    static Charset UTF  = Charset.forName("UTF-8");
    public static void main(String[] args) throws IOException {
        String filename1 = null;
        String filename2 = null;
        if (args.length == 2) {
            filename1 = args[0];
            filename2 = args[1];
        }
        else {
            filename1 = "C:\\new.txt";
            filename2 = "C:\\new1.txt";
        }
        try (FileInputStream fileReader = new FileInputStream(filename1);
        FileOutputStream fileWriter = new FileOutputStream(filename2)
        )
        {
          byte[] buff = new byte[fileReader.available()];
            fileReader.read(buff);
            String s = new String(buff,UTF);


            fileWriter.write(s.getBytes(Wind));


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
