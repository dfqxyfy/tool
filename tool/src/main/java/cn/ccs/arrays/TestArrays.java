package cn.ccs.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestArrays {
    public static void main(String[] args) {
        int[] va = new int[]{3,1,2,4};
        LongStream longStream = Arrays.stream(va).filter(new IntPredicate() {
            @Override
            public boolean test(int value) {
                if (value < 2) {
                    return false;
                }
                return true;
            }
        }).sorted().mapToLong(new IntToLongFunction() {
            @Override
            public long applyAsLong(int value) {
                return (long) value;
            }
        });
        longStream.forEach(l->{
            System.out.println(l);
        });


        Integer[] va2 = new Integer[]{3,1,2,4,4,5};
        List<Integer> list = Arrays.asList(va2);
        Stream<Integer> stream = list.stream();
        Stream<User> userStream = stream.map(new Function<Integer, User>() {
            @Override
            public User apply(Integer integer) {
                User user = new User();
                user.age = integer;
                user.name = "name_" + integer * 2 + "";
                return user;
            }
        });
//        Integer collect1 = userStream.collect(new Collector<User, String, Integer>() {
//
//            @Override
//            public Supplier<String> supplier() {
//                return null;
//            }
//            @Override
//            public BiConsumer<String, User> accumulator() {
//                return null;
//            }
//            @Override
//            public BinaryOperator<String> combiner() {
//                return null;
//            }
//            @Override
//            public Function<String, Integer> finisher() {
//                return null;
//            }
//            @Override
//            public Set<Characteristics> characteristics() {
//                return null;
//            }
//        });
        System.out.println("********");
        Double collect1 = userStream.collect(Collectors.averagingInt(new ToIntFunction<User>() {
            @Override
            public int applyAsInt(User value) {
                if (value.age > 3) {
                    System.out.println(value.age +" 4");
                    return 6;
                }
                System.out.println(value.age + " 1");
                return 1;
            }
        }));
        System.out.println("********");
        System.out.println(collect1);
        System.out.println("********");
//        List<User> collect = userStream.collect(Collectors.toList());
//        collect.forEach(user -> {
//            System.out.println(user.age);
//        });
    }
}
class User{
    int age;
    String name;
}