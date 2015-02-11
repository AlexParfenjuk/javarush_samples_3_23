package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-с  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
 инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.RandomAccessFile;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) throws Exception {
        String productName = null;
        String price = null;
        String quantity = null;
        if (args.length > 1) {
            if (  ("-c".equals(args[0])  ) && args.length == 4) {
                productName = args[1];
                price = args[2];
                quantity = args[3];

            }
        }else {
            productName = "Boobs";
            price = "13.4";
            quantity = "2";
        }

        Scanner in = new Scanner(System.in);

            String filename = "C:\\new1.txt";//in.nextLine();
            in.close();
            RandomAccessFile fileOne = new RandomAccessFile(filename, "rw");
            int maxId = 0;
            String line = fileOne.readLine();
            boolean isEmpty = Empty(line);
            while (line != null) {
                if (!"".equals(line)) {
                    System.out.println(line);
                    int id = Integer.parseInt(line.substring(0, 8).trim());
                    if (id > maxId)
                        maxId = id;
                }
                line = fileOne.readLine();
            }
            maxId++;
            String formatted = String.format("%-8d%-30.30s%-8.8s%-4.4s",maxId,productName,price,quantity);
            if (!isEmpty) fileOne.writeBytes("\n");
            fileOne.writeBytes(formatted);
            fileOne.close();

        }

    public  static boolean Empty(String line) {
        if (line == null)
            return true;
        else
            return false;
    }

    }





