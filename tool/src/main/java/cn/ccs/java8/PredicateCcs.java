package cn.ccs.java8;

import java.util.function.Predicate;

public class PredicateCcs {

    public static void main(String[] args) {
        Predicate<Integer> predicate = i->i>5;

        System.out.println(predicate.test(9));
    }
}
