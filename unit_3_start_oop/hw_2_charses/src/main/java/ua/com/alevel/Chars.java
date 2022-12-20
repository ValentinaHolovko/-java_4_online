package ua.com.alevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class Chars {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        HashMap<Character, Integer> results;
        System.out.println("Введите строку с использованием латиницы или кириллицы. Нажмите //Enter//");
        while (!(line = reader.readLine()).equals("выход")) {
            results = new HashMap<>();
            char[] array = line.toCharArray();
            for (char s: array) {
                if (((s >= 'a' && s <= 'z')||(s >= 'A' && s <= 'Z'))||((s >= 'а' && s <= 'я')||(s >= 'А' && s <= 'Я'))) {
                    if (results.containsKey(s))
                        results.put(s, results.get(s) + 1);
                    else
                        results.put(s, 1);
                }
            }
            List<Character> result = results.keySet().stream().sorted().toList();
            for (int i = 0; i < result.size(); i++) {
                System.out.printf("%d) %s = %d, ", i + 1, result.get(i), results.get(result.get(i)));
            }
            System.out.println("\nПосле окончания работы напишите - выход");
        }
    }
}