package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null) return false;
        if (getClass() != o.getClass())
            return false;
        Solution n = (Solution) o;
        if (  (this.first == null) ? (n.first != null)  : !this.first.equals(n.first))
        {return false;}
        if (  (this.last == null) ? (n.last != null)  : !this.last.equals(n.last))
        {return false;}


        return true;
    }


    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.first != null ? this.first.hashCode() : 0);
        hash = 53 * hash + (this.last != null ? this.last.hashCode() : 0);
        return hash;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", null));
        System.out.println(s.contains(new Solution("Donald",null)));
    }
}
