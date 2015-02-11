package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Roodie on 09.08.2014.
 */
public class USD extends Money{
    public USD(double amount) {
        super(amount);
    }

    public  String getCurrencyName(){return  "USD";}

}
