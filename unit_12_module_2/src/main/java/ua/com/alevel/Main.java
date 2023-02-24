package ua.com.alevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        try {
            String fileName = "unit_12_module_2/src/main/resources/input.txt";
            String content = Files.readString(Paths.get(fileName));
            String[] lines = content.split("\n");

            int n = Integer.parseInt(lines[0].trim());
            int[][] graph = new int[n][n];
            String[] cityNames = new String[n];

            for (int i = 0; i < n; i++) {
                String[] parts = lines[i + 1].trim().split(" ");
                cityNames[i] = parts[0];
                for (int j = 1; j < parts.length; j++) {
                    graph[i][j - 1] = Integer.parseInt(parts[j]);
                }
            }

            String[] startEnd = lines[n + 1].trim().split(" ");
            String start = startEnd[0];
            String end = startEnd[1];

            int startIdx = Arrays.asList(cityNames).indexOf(start);
            int endIdx = Arrays.asList(cityNames).indexOf(end);

            int[] cheapestCosts = IntStream.generate(() -> Integer.MAX_VALUE).limit(n).toArray();
            cheapestCosts[startIdx] = 0;

            int[] queue = new int[n];
            int queueStart = 0, queueEnd = 0;
            queue[queueEnd++] = startIdx;

            while (queueStart < queueEnd) {
                int curr = queue[queueStart++];
                for (int i = 0; i < n; i++) {
                    if (graph[curr][i] > 0) {
                        int cost = cheapestCosts[curr] + graph[curr][i];
                        if (cost < cheapestCosts[i]) {
                            cheapestCosts[i] = cost;
                            queue[queueEnd++] = i;
                        }
                    }
                }
            }

            int cheapestCost = cheapestCosts[endIdx];
            if (cheapestCost == Integer.MAX_VALUE) {
                System.out.println("No way out " + start + " в " + end);
            } else {
                System.out.println("The most profitable way from " + start + " в " + end + " price " + cheapestCost + " UAH.");
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }
    }
}
