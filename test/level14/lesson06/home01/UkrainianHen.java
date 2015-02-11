package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Roodie on 09.08.2014.
 */
public class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth() {return 7;}
    String getDescription() {return super.getDescription() + " Моя страна - "+ Country.UKRAINE + ". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";}
}
