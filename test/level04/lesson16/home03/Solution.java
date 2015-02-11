package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //Напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean b = false;
        int i;
        int sum  = 0;
        while(!b)
        {
            i = Integer.parseInt(br.readLine());
            list.add(i);
            if (i == -1)
                b = true;
        }
        for(Integer el:list)
            sum+=el;
        System.out.println(sum);
    }
}
