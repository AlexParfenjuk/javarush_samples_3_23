package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int MAX = -1;

        while (!(MAX > 0)) {
            System.out.print("Enter the amount(N > 0):");
            MAX = Integer.parseInt(reader.readLine());
        }
        int maximum = Integer.parseInt( reader.readLine() );

        for ( int i = 1; i < MAX ; i++ )
        {
            int nextNumber = Integer.parseInt( reader.readLine() );
            if ( nextNumber > maximum )
            {
                maximum = nextNumber;
            }
        }

        System.out.println(maximum);
    }
}
