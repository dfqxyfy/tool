package cn.ccs.btrace.demo;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Random random = new Random();
        while (true) {
            int a = random.nextInt(10);
            int b = random.nextInt(20);
            int c = calc.add(a, b);
            System.out.println(String.format("%d + %d = %d", a, b, c));
        }
    }
}