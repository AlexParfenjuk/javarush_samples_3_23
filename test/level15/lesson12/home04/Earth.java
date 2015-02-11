package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Roodie on 11.08.2014.
 */
public class Earth implements Planet {
    public static Earth earth;

    private  Earth() {}
    public static Earth getInstance() {

        if ( earth == null) {
            earth = new Earth();

        }
        return  earth;

    }
}
