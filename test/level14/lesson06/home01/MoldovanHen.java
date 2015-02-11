package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Roodie on 09.08.2014.
 */
public class MoldovanHen extends Hen {
    public int getCountOfEggsPerMonth() {return 4;}
    String getDescription() {return super.getDescription() + " Моя страна - "+ Country.MOLDOVA + ". Я несу "+getCountOfEggsPerMonth() +" яиц в месяц.";}
}
