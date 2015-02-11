package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Roodie on 11.08.2014.
 */
public class Sun implements Planet {
    public static Sun sun;
    private Sun () {}

    public static Sun getInstance() {
        if (sun == null) {
            sun = new Sun();
        }
        return sun;
    }

}
