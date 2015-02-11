package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.print("Enter Grandfathers name:");
        String GfatherName = reader.readLine();
        Cat GFather = new Cat(GfatherName);

        //System.out.print("Enter Grandmothers name:");
        String GmotherName = reader.readLine();
        Cat GMother = new Cat(GmotherName);

        //System.out.print("Enter fathers name:");
        String fatherName = reader.readLine();
        Cat Father = new Cat(fatherName,GFather,null);

        //System.out.print("Enter mothers name:");
        String motherName = reader.readLine();
        Cat Mother = new Cat(motherName,null,GMother);

        //System.out.print("Enter sons name:");
        String sonsName = reader.readLine();
        Cat Son = new Cat(sonsName,Father,Mother);

        //System.out.print("Enter daughters name:");
        String daughterName = reader.readLine();
        Cat Daughter = new Cat(daughterName,Father,Mother);


        System.out.println(GFather);
        System.out.println(GMother);
        System.out.println(Father);
        System.out.println(Mother);
        System.out.println(Son);
        System.out.println(Daughter);

    }

    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name)
        {
            this.name = name;
        }

        public Cat(String name,Cat father, Cat mother ) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (father == null)
                return "Cat name is " + name +  ", mother is " + mother.name + ", no father";
            else if (mother == null)
                return "Cat name is " + name + ", no mother" + ", father is "+ father.name;
            else
                return "Cat name is " + name + ", mother is " + mother.name + ", father is "+ father.name;
        }
    }

}