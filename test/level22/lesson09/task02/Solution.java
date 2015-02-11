package com.javarush.test.level22.lesson09.task02;

import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {


    public static StringBuilder getCondition(Map<String, String> params) {
        if (params == null)
            return new StringBuilder();
        if (params.isEmpty())
            return  new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String,String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                builder.append(entry.getKey());
                builder.append(" = '" + entry.getValue() + "'");
                builder.append(" and ");

            }

        }
        builder = builder.delete(builder.lastIndexOf(" and "), builder.length());
        return builder;
    }
}
