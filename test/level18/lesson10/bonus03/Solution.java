package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import com.sun.org.apache.xpath.internal.operations.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.String;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int ID = 0;
        String FirstArgument = null;
        String PRODUCTNAME = null;
        String PRICE = null;
        String QUANTITY = null;
        if (args.length > 1) {
            if (  ("-u".equals(args[0])  ) && args.length == 5) {
                FirstArgument = args[0];
                ID = Integer.parseInt(args[1]);
                PRODUCTNAME = args[2];
                PRICE = args[3];
                QUANTITY = args[4];

            }
            else if (  ("-d".equals(args[0])  ) && args.length == 2) {
                FirstArgument = args[0];
                ID = Integer.parseInt(args[1]);
            }
        } else {
            FirstArgument = "-d";
            ID = 2;
            PRODUCTNAME = "UpdateedBoobies";
            PRICE = "888.4";
            QUANTITY = "2";
        }

        Scanner in = new Scanner(System.in);

        try {
            String filename = "C:\\new1.txt";//in.nextLine();
            in.close();
            RandomAccessFile fileOne = new RandomAccessFile(filename, "rw");
            if (  ("-u".equals(FirstArgument)  )) {
                String formatted = String.format("%-8d%-30.30s%-8.8s%-4.4s",ID,PRODUCTNAME,PRICE,QUANTITY);
                updateRecord(ID,fileOne,formatted);

            }
            else if (  ("-d".equals(FirstArgument) )) {
                 deleteRecord(ID,fileOne);
            }


         viewAll(fileOne);
         fileOne.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }


 public static void updateRecord(int IDToUpdate, RandomAccessFile randomAccessFile,String datas) throws IOException {
      boolean success = false;
      boolean isEmpty = true;
      randomAccessFile.seek(0);
     List<String> list = new ArrayList<String>();

        while (true) {
            String data = randomAccessFile.readLine();
            if (data == null) break;
                list.add(data);
        }
     int index = 0;

     Iterator<String> iterator = list.iterator();
         while (iterator.hasNext()) {
                 String curr = iterator.next();
                 int CurrentID = Integer.parseInt(curr.substring(0, 8).trim());
                 if(IDToUpdate == CurrentID) {
                 success = true;
                  break;
                  }
                 index++;
         }

     if (success) {
         list.remove(index);
         list.add(index,datas);
         randomAccessFile.setLength(0);
         for (String str : list) {
             if (!isEmpty) randomAccessFile.writeBytes("\n");
             randomAccessFile.writeBytes(str);
             isEmpty = false;
         }
         System.out.println("Updated!");
     }


    }
    /////////////////////////////////////////////////////////
    public static void deleteRecord(int IDToDelete, RandomAccessFile randomAccessFile) throws IOException {
        boolean success = false;
        boolean isEmpty = true;
        randomAccessFile.seek(0);
        List<String> list = new ArrayList<String>();

        while (true) {
            String data = randomAccessFile.readLine();
            if (data == null) break;
            list.add(data);
        }
        int index = 0;

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String curr = iterator.next();
            int CurrentID = Integer.parseInt(curr.substring(0, 8).trim());
            if(IDToDelete == CurrentID) {
                success = true;
                break;
            }
            index++;
        }

        if (success) {
            list.remove(index);
            randomAccessFile.setLength(0);
            for (String str : list) {
                if (!isEmpty) randomAccessFile.writeBytes("\n");
                randomAccessFile.writeBytes(str);
                isEmpty = false;
            }
            System.out.println("Deleted!");
        }
    }
    //////////////////////////////////
    public static void viewAll(RandomAccessFile randomAccessFile) throws IOException {
        String data ;
        //This is responsible for reading complete file
        randomAccessFile.seek(0);
        data = randomAccessFile.readLine();
        while (data != null){
            System.out.println(data);
            data = randomAccessFile.readLine();
        }

    }
}
