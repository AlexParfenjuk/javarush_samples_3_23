package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Roodie on 09.08.2014.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}
