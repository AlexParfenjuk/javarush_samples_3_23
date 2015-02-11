package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static void main(String[] args) throws Exception
    {
       Solution qq = new Solution();
       qq. fillInPropertiesMap();



        for (Map.Entry<String,String> ff : properties.entrySet()) {
            System.out.println(ff.getKey() + " = " + ff.getValue());
        }

    }

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try {
            Scanner in = new Scanner(System.in);
            String filename = in.nextLine();
            in.close();
            InputStream fileIn = new FileInputStream(new File(filename));
            load(fileIn);


        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
        //implement this method - реализуйте этот метод
        try {
            for (Map.Entry<String,String> entry : properties.entrySet())
                props.setProperty(entry.getKey(),entry.getValue());
            props.store(outputStream,null);
            }
        catch (Exception em) {
            em.printStackTrace();
        }
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();

                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        try {
            Properties props = new Properties();
            props.load(inputStream);
            Enumeration<?> e = props.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = props.getProperty(key);
                properties.put(key, value);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if ( inputStream != null) {
                try {
                    inputStream.close();

                } catch ( IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
