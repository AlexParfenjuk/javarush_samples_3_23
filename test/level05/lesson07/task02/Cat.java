package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    String name;
    int age;
    int weight;
    int color;
    String adress;

    public void initialize(String adress,int color, int weight) {

        this.adress = adress;
        this.color = color;
        this.weight = weight;
        age = 3;
        name = "Vaska";
    }

    public void initialize( int color, int weight) {

        this.adress = null;
        this.color = color;
        this.weight = weight;
        age = 2;
        this.name = null;
    }


    public void initialize(int age, String name, int weight) {

        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void initialize(String name, int age) {

        this.name = name;
        this.age = age;
        weight = 10 ;
    }

    public void initialize(String name) {

        this.name = name;
    }
}
