package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(Exception ex) {}
    public Solution(Integer i) {}
    public Solution(Object o) {}


    protected Solution(Character c){}
    protected Solution(Double d){}
    protected Solution(String i){}

    private Solution (Boolean v) {}
    private Solution(Float i) {}
    private Solution(Number i) {}

    Solution (int i) {}
    Solution(char c) {}
    Solution(float t) {}


}

