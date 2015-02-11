package com.javarush.test.level15.lesson12.home04;


/**
 * Created by Roodie on 11.08.2014.
 */
public class Moon implements Planet {
    public static Moon moon;
    private Moon() {}

    public static Moon getInstance() {

        if (moon == null) {
            moon = new Moon();
        }
        return moon;
    }
}
