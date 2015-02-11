package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        int weight;
        short id;
        Human father;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age, boolean sex, short id) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.id = id;
        }

        public Human(String name, short id) {

            this.name = name;
            this.id = id;
        }

        public Human(String name, Human father, short id) {

            this.name = name;
            this.father = father;
            this.id = id;
        }

        public Human(boolean sex, String name, short id) {

            this.sex = sex;
            this.name = name;
            this.id = id;
        }

        public Human(String name, int age, boolean sex, int weight, short id, Human father) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.id = id;
            this.father = father;
        }

        public Human(String name, int age, boolean sex, int weight, short id) {

            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.id = id;
        }

        public Human(String name, int age, boolean sex, int weight) {

            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
        }

        public Human(String name, int age, boolean sex) {

            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age) {

            this.name = name;
            this.age = age;
        }
    }
}
