package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConsoleTable {
    public static void main(String[] args) {
        String leftAlignFormat = "| %-15s | %-6d | %-6d | %-11.2f |%n";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numLines = 0;
            String text;
            do {
                System.out.print("Enter your text: ");
                text = reader.readLine();
                numLines++;
            } while (text.trim().isEmpty());

            Map<String, Long> countWords = Arrays.stream(text.split("[^\\p{L}]+"))
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            int totalWords = countWords.values().stream().mapToInt(value -> Math.toIntExact(value)).sum();


            int rating = 1;

            System.out.format("+-----------------+--------+--------+-------------+%n");
            System.out.format("|       Words     | Rating |  Count |  Percentage |%n");
            System.out.format("+-----------------+--------+--------+-------------+%n");

            for (Map.Entry<String, Long> entry : countWords.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toList())) {
                String word = entry.getKey();
                long count = entry.getValue();
                double percent = count * 100.0 / (double) totalWords;
                System.out.format(leftAlignFormat, word, rating++, count, percent);
            }

            System.out.format("+-----------------+--------+--------+-------------+%n");
            System.out.println("Number of lines entered: " + numLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
