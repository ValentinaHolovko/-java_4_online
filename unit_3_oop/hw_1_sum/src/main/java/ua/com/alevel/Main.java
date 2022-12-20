package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader isolate = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введіть доданки:");
        String select;
        int sum;
        while ((select = isolate.readLine()) != null) {
            sum = 0;
            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = pattern.matcher(select);
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }
            System.out.println("Сума доданків:");
            System.out.println(sum);

        }
    }

}