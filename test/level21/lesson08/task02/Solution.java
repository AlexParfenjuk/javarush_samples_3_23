package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", null);
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }


    }

    public static class Tree extends Plant  implements  Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }


        @Override
        protected Tree clone() throws CloneNotSupportedException {
            Tree obj = null;
            if (this.branches == null) {
                obj = new Tree(this.getName(), null);
                return obj;
            }
            String[] branch = new String[this.branches.length];
            System.arraycopy(this.getBranches(),0,branch,0,this.getBranches().length);
            obj = new Tree(this.getName(),branch);
            return obj;
        }
    }
}
