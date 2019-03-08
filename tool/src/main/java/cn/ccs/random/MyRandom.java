package cn.ccs.random;

import java.util.Random;

public class MyRandom {
    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(1000);
        System.out.println(random.nextInt());

        Random random2 = new Random();
        random2.setSeed(1000);
        System.out.println(random2.nextInt());
    }
}
