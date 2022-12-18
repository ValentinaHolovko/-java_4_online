
package ua.com.alevel;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int count = 12;
        Random random = new Random();
        Group[] hw = new Group[random.nextInt(count)];
        System.out.println("hw = " + hw.length);

        for (int i = 0; i < hw.length; i++) {
            hw[i] = new Group();
            hw[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(1);
            if (result == 0) {
                hw[i].isStupid = true;
            } else {
                hw[i].isStupid = false;
            }
        }

        for (int i = 0; i < hw.length; i++) {
            System.out.println(
                    "hw = " + hw[i].name + " " + hw[i].isStupid);
        }
        for (int i = 1; i < hw.length; i++) {
            hw[i] = new Group();
            hw[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(2);
            if (result == 1) {
                hw[i].isStupid = true;
            } else {
                hw[i].isStupid = false;
            }
        }

        for (int i = 1; i < hw.length; i++) {
            System.out.println(
                    "hw = " + hw[i].name + " " + hw[i].isStupid);
        }
        for (int i = 2; i < hw.length; i++) {
            hw[i] = new Group();
            hw[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(3);
            if (result == 2) {
                hw[i].isStupid = true;
            } else {
                hw[i].isStupid = false;
            }
        }

        for (int i = 2; i < hw.length; i++) {
            System.out.println(
                    "hw = " + hw[i].name + " " + hw[i].isStupid);
    }
        for (int i = 3; i < hw.length; i++) {
            hw[i] = new Group();
            hw[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(4);
            if (result == 3) {
                hw[i].isStupid = true;
            } else {
                hw[i].isStupid = false;
            }
        }

        for (int i = 3; i < hw.length; i++) {
            System.out.println(
                    "hw = " + hw[i].name + " " + hw[i].isStupid);
}
        for (int i = 4; i < hw.length; i++) {
            hw[i] = new Group();
            hw[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(5);
            if (result == 4) {
                hw[i].isStupid = true;
            } else {
                hw[i].isStupid = false;
            }
        }

        for (int i = 4; i < hw.length; i++) {
            System.out.println(
                    "hw = " + hw[i].name + " " + hw[i].isStupid);
}        for (int i = 5; i < hw.length; i++) {
            hw[i] = new Group();
            hw[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(6);
            if (result == 5) {
                hw[i].isStupid = true;
            } else {
                hw[i].isStupid = false;
            }
        }

        for (int i = 5; i < hw.length; i++) {
            System.out.println(
                    "hw = " + hw[i].name + " " + hw[i].isStupid);
    }}}