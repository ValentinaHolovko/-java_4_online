package ua.com.alevel.hw_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShcoolMain {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        int define;
        int time;
        System.out.println("enter lesson number 1-10");
        while (!(string = reader.readLine()).equals("stop")) {
            try {
                time = Integer.parseInt(string);
                if (time >= 0 && time <= 10) {
                    define = time * 45 + ((time / 2) * 5) + (((time - 1) / 2) * 15);
                    System.out.println((define / 60 + 9) + ":" + (define % 60));
                }
            } catch (Exception e){
                System.out.println(string + " \n" +
                        "enter lesson number 1-10");
            }
        }
    }
}


