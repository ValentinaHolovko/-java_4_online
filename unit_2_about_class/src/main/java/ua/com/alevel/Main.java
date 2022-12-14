package ua.com.alevel;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int count = 30;
        Random random = new Random();
        Group[] hw = new Group[random.nextInt(count)];
        System.out.println("hw = " + hw.length);

        for (int i = 0; i < hw.length; i++) {
            hw[i] = new Group();
            hw[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(3);
            if (result == 0) {
                hw[i].isStupid = true;
            } else {
                hw[i].isStupid = false;
            }
        }

        for (int i = 0; i < hw.length; i++) {
            System.out.println(
                    "hw = " + hw[i].name + " " + hw[i].isStupid
            );
        }
    }
}