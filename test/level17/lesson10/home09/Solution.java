package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые
есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String filename1 ;
    public static String filename2 ;

    public static void main(String[] args) throws  CorruptedDataException{
        enterFilenames();
        readFromFiles();
        Solution solution = new Solution();
        solution.joinData();




    }




    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            for (String remove : forRemoveLines) {
                if (!allLines.contains(remove)) {
                    allLines.clear();
                throw new CorruptedDataException();



                }
            }
        }
    }


    public static void enterFilenames() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            filename1 = reader.readLine();
            filename2 = reader.readLine();
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }



    public  static  void readFromFiles() {
        try {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(filename1)));
            while (true) {
                String s = reader1.readLine();
                if(s == null)
                    break;
                allLines.add(s);
            }
            reader1.close();
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(filename2)));
            while (true) {
                String s = reader2.readLine();
                if(s == null)
                    break;
                forRemoveLines.add(s);
            }
            reader2.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
