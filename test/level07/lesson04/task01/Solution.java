package com.javarush.test.level07.lesson04.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/* Максимальное среди массива на 20 чисел
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }
    public static int[] initializeArray() throws IOException {
        //initialize(create and fill) an array here - инициализируйте (создайте и заполните) массив тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Random random = new Random();
        int [] mass = new int[20];
        for ( int i = 0; i < mass.length ;i++ )
            mass[i] = Integer.parseInt(br.readLine());
        //mass[i] = random.nextInt();
        return mass;
    }

    public static int max(int[] array) {
        //find the max value here - найдите максимальное значение в этом методе
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > min)
                min = array[i];
        }

        return min;
    }
}
