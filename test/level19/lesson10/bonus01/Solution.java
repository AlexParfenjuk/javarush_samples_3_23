package com.javarush.test.level19.lesson10.bonus01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String file1 = in.nextLine();
            String file2 = in.nextLine();
            in.close();
            BufferedReader ReaderFile1 = new BufferedReader(new FileReader(file1));
            BufferedReader ReaderFile2 = new BufferedReader(new FileReader(file2));
            ArrayList<String> list1 = new ArrayList<String>();
            ArrayList<String> list2 = new ArrayList<String>();

            String s = null;
            while (ReaderFile1.ready()) {
                list1.add(ReaderFile1.readLine());
            }
            while (ReaderFile2.ready()) {
               list2.add(ReaderFile2.readLine());
            }
            if (list1.size() > list2.size())
                UnionFiles(list1,list2);
            else
            UnionFiles(list2,list1);

            for (LineItem item : lines)
                System.out.println(item);

            ReaderFile1.close();
            ReaderFile2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void UnionFiles (ArrayList<String> longer,ArrayList<String> shorter) {
        for (int i = 0,j = 0; i < longer.size(); i++,j++){
            if (j >= shorter.size()) {
                lines.add(new LineItem(Type.ADDED,longer.get(i)));
            }
            else {
                if (longer.get(i).equals(shorter.get(j))){
                    lines.add(new LineItem(Type.SAME,longer.get(i)));
                }
                else  if (!longer.get(i).equals(shorter.get(j))) {
                    if (longer.get(i+1).equals(shorter.get(j))) {
                        lines.add(new LineItem(Type.ADDED, longer.get(i)));
                        j--;
                    }
                    else {
                        lines.add(new LineItem(Type.REMOVED, shorter.get(j)));
                        i--;
                    }
                }

            }
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "type=" + type +
                    ", line='" + line + '\'' +
                    '}';
        }
    }
}
