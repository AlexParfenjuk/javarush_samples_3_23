package com.javarush.test.level18.lesson10.home08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь
resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        try {
            String s;
            while (true) {
                //System.out.print("Enter file:");
                s = in.nextLine();
                if (s.equals("exit")) break;
                Thread news = new ReadThread(s);
                news.start();
                news.join();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        for (Map.Entry<String,Integer> entry : resultMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        in.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
         }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public  void run(){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            try {
            FileInputStream fileInputStream = new FileInputStream(fileName);

            while (fileInputStream.available() > 0) {
                    int cur = fileInputStream.read();
                    if (map.containsKey(cur)) {
                        map.put(cur, map.get(cur) + 1);
                    } else {
                        map.put(cur, 1);
                    }
                }

                int maxpovt = 0;
                int symbol = 0;
                for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxpovt) {
                        maxpovt = entry.getValue();
                        symbol = entry.getKey();
                    }

                }
                resultMap.put(fileName, symbol);
                fileInputStream.close();
            }
            catch (FileNotFoundException e){
                System.out.println("File not found!");}
            catch (IOException e) {e.printStackTrace();}

         }
    }
}
