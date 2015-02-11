package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        int[] a1 = new int[10];
        int[] a2 = new int[10];
       // Random random = new Random();
        for(int i = 0;i < array.length; i++)
            //array[i] = random.nextInt();
            array[i] = Integer.parseInt(br.readLine());
        for(int i = 0;i < (array.length / 2)-1; i++)
            a1[i] = array[i];
        for(int i = (array.length / 2);i < array.length; i++)
            a2[i-10] = array[i];
        for(int i :a2)
            System.out.println(i);



    }
}
