package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Roodie on 11.08.2014.
 */
public class SubSolution extends Solution {

    SubSolution(float t) {
        super(t);
    }

    SubSolution(char c) {
        super(c);
    }

    SubSolution(int i) {
        super(i);
    }

    private SubSolution (Boolean v) {
        super(v);
    }

    private SubSolution (Float i) {
        super( i);
    }

    private SubSolution (Number i) {
        super(i);
    }

    protected SubSolution(String i) {
        super(i);
    }

    protected SubSolution(Double d) {
        super(d);
    }

    protected SubSolution(Character c) {
        super(c);
    }

    public SubSolution(Object o) {

        super(o);
    }

    public SubSolution(Integer i) {

        super(i);
    }

    public SubSolution(Exception ex) {

        super(ex);
    }
}
