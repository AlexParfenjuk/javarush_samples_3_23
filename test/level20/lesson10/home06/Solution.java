package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    static final long serialVersionUID = 2L;
    public Solution () {}
    public static class SubSolution extends Solution {
        static final long serialVersionUID = 2L;
        public  SubSolution () throws NotSerializableException{
            throw new NotSerializableException();

        }
    }
}
