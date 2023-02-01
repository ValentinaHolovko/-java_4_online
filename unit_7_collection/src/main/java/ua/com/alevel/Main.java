package ua.com.alevel;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MatList<Short> matList = new MatList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) matList.add((short) ((i) * random.nextInt(10)));
        System.out.printf(String.valueOf(matList));
    }
}
