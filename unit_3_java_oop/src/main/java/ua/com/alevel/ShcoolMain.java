package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShcoolMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum;
        int number;

        System.out.println("Введите номер уроку (0-10)");


            number = Integer.parseInt(bufferedReader.readLine());

            int totalInMinutes = ((number * 45) + ((number - 1) / 2) * 15) + ((((number - 1) / 2) + ((number - 1) % 2)) * 5);
            int hoursLesson = totalInMinutes / 60 + 9;
            int minutesLesson = totalInMinutes % 60;
            System.out.println(hoursLesson + ":" + minutesLesson);


        }
    }
