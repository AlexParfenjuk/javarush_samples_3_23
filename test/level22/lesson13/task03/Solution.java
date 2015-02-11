package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println("+380501234567 t "   + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567- f " + checkTelNumber("+38(050)1234567-"));
        System.out.println("+38050(123)(456)7 t " + checkTelNumber("+38050(123)(456)7"));
        System.out.println("++380501234567 f " + checkTelNumber("++380501234567"));
        System.out.println("(380)501234567 f " + checkTelNumber("(380)501234567"));
        System.out.println("+38050123--4567 f " + checkTelNumber("+38050123--4567"));
        System.out.println("050123--4567 f " + checkTelNumber("050123--4567"));
        System.out.println("0-50123-4567 t " + checkTelNumber("0-50123-4567"));
        System.out.println("+38)050(1234567 f " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 f " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 f " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 f " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 f " + checkTelNumber("(0)501234567"));
        System.out.println("+38-(050)1234567 f " + checkTelNumber("+38-(050)1234567"));
        System.out.println("+38((050)1234567 f " + checkTelNumber("+38((050)1234567"));
        System.out.println("+5(0--5)1234567 f " + checkTelNumber("+5(0--5)1234567"));
        System.out.println("1-23456789-0 t " + checkTelNumber("1-23456789-0"));
        System.out.println("+38051202(345)-7 t " + checkTelNumber("+38051202(345)-7"));
        System.out.println("+38051202(345)7 t " + checkTelNumber("+38051202(345)7"));
        System.out.println("(345)0512027 t " + checkTelNumber("(345)0512027"));
        System.out.println("+-313450531202 t " + checkTelNumber("+-313450531202"));
        System.out.println("+313450--531202 f " + checkTelNumber("+313450--531202"));
        System.out.println("38xx501A34567 f " + checkTelNumber("38xx501A34567"));
        System.out.println("3805012345 t " + checkTelNumber("3805012345"));
        System.out.println("+38(0501234567 f " + checkTelNumber("+38(0501234567"));
        System.out.println("+38(050)1234567 t " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38(05)1234567 f " + checkTelNumber("+38(05)1234567"));
        System.out.println("(3)80501234567 f " + checkTelNumber("(3)80501234567"));
        System.out.println("380-50123-45 t " + checkTelNumber("380-50123-45"));
        System.out.println("(380)501-234567 f " + checkTelNumber("(380)501-234567"));
        System.out.println("(38-0)501234567 f " + checkTelNumber("(38-0)501234567"));
        System.out.println("380-(501)234567 f " + checkTelNumber("380-(501)234567"));
        System.out.println("380(50-1)234567 f " + checkTelNumber("380(50-1)234567"));
        System.out.println("380(501)(23)4567 f " + checkTelNumber("380(501)(23)4567"));
        System.out.println("+38050123(456)7 t " + checkTelNumber("+38050123(456)7"));
        System.out.println("+38050123(456)76 f " + checkTelNumber("+38050123(456)76"));
        System.out.println("+380501234(567) f " + checkTelNumber("+380501234(567)"));
        System.out.println("3-805-0123-45 f " + checkTelNumber("3-805-0123-45"));
        System.out.println("-3805-012345 f " + checkTelNumber("-3805-012345"));
        System.out.println("3805-012345- f " + checkTelNumber("3805-012345-"));
        System.out.println("+38(05)01234567  f " + checkTelNumber("+38(05)01234567"));
        System.out.println("+38(0501)234567 f " + checkTelNumber("+38(0501)234567"));
        System.out.println("+38050123-45-67 t " + checkTelNumber("+38050123-45-67"));
        System.out.println("05012050123-4567 t " + checkTelNumber("050123-4567"));
        System.out.println("7-4-4123689-5 f " + checkTelNumber("7-4-4123689-5"));
        System.out.println("+313450--531202Э f " + checkTelNumber("+313450--531202Э"));

    }

    public static boolean checkTelNumber(String telNumber) {
        if(telNumber.matches("^.*[a-z]+.*") || telNumber.matches(".*\\-{2,}.*") || telNumber.matches("^.*\\-.*\\-.*\\-.*$"))//не содержит букв, два - не подряд, и их не больше двух
            return false;
        if(telNumber.matches("^\\+[0-9,\\-,\\(,\\)]{11,15}[0-9]$") || telNumber.matches("^[0-9][0-9,\\(,\\),\\-]{8,12}[0-9]$") || telNumber.matches("^\\([0-9,\\),\\-]{9,13}[0-9]$")) {
            if ((telNumber.matches("^[^\\(,\\-,\\)]*\\([0-9]{3}\\)[^\\(,\\)]*$") || telNumber.matches("^[^\\(,\\)]*$")))//содержит скобки по условию, или вообще не содержит
                return true;
            else return false;
        }
        return false;
    }
}
