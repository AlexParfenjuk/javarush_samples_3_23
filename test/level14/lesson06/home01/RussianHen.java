package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Roodie on 09.08.2014.
 */
public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth() {return 6;}
    String getDescription() {return super.getDescription() + " Моя страна - "+ Country.RUSSIA + ". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";}
}

