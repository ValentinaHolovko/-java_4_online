package ua.com.alevel;

import java.util.Random;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        MatList<Integer> matList = new MatList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            matList.add((i) * random.nextInt(10));
        }
        System.out.println(matList);
    }
}
