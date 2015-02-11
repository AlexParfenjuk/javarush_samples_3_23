package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human[] family = new Human[9];
        ArrayList<Human> children = new ArrayList<Human>();
        family[0] = new Human("child1",true,4);
        family[1] = new Human("child2",false,5);
        family[2] = new Human("child3",true,7);
        children.add(family[0]);
        children.add(family[1]);
        children.add(family[2]);

        family[3] = new Human("Father",true,75,children);
        family[4] = new Human("Mother",false,75,children);
        children = new ArrayList<Human>();
        children.add(family[3]);

        family[5] = new Human("Bab1",false,75,children);
        family[6] = new Human("Ded1",true,75,children);
        children = new ArrayList<Human>();
        children.add(family[4]);
        family[7] = new Human("Bab2",false,75,children);
        family[8] = new Human("Ded2",true,75,children);
        for(Human person :family)
            System.out.println(person);
    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
