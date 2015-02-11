package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Roodie on 09.08.2014.
 */
public class Singelton {
    private static Singelton ourInstance = new Singelton();

    public static Singelton getInstance() {
        return ourInstance;
    }

    private Singelton() {
    }
}
