package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        ArrayList<Human> humans = new ArrayList<Human>();
        humans.add(new Human("Ded1",true,76,null,null));
        humans.add(new Human("Ded2",true,76,null,null));
        humans.add(new Human("Bab1",false,76,null,null));
        humans.add(new Human("Bab2",false,76,null,null));
        humans.add(new Human("Father1",true,76,humans.get(0),humans.get(2)));
        humans.add(new Human("Mother1",false,76,humans.get(1),humans.get(3)));
        humans.add(new Human("Child1",true,76,humans.get(4),humans.get(5)));
        humans.add(new Human("Child2",false,76,humans.get(4),humans.get(5)));
        humans.add(new Human("Child3",true,76,humans.get(4),humans.get(5)));
        for(Human n : humans)
            System.out.println(n);
       /* Human ded1 = new Human();
        Human ded2 = new Human();
        Human bab1 = new Human();
        Human bab2 = new Human();
        Human father = new Human();
        Human mother = new Human();
        Human child1 = new Human();
        Human child2 = new Human();
        Human child3 = new Human();

     */
    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;


        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
