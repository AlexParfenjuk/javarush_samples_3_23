package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Roodie on 09.08.2014.
 */
public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {return 5;}
    String getDescription() {return super.getDescription() + " Моя страна - "+ Country.BELARUS + ". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";}
}