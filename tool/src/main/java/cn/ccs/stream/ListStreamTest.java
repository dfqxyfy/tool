package cn.ccs.stream;

import com.google.common.base.Function;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ListStreamTest {
    public static void main(String[] args) {
        List<Attr> list = Stream.of(new Attr("a", "code"), new Attr("b", "code"), new Attr("c", "code2")).collect(toList());

        Map<String, String> collect1 = list.stream().collect(Collectors.toMap(Attr::getAttr, Attr::getBizCode, (v1, v2) -> v1));
        System.out.println(collect1);

        Attr attr = new Attr("a", "code");

        Function<Attr, String> getBizCode = Attr::getBizCode;
        String apply = getBizCode.apply(attr);
        System.out.println(apply);

        BiConsumer<Attr, String> code = Attr::setBizCode;
        code.accept(attr,"ccccc");
        System.out.println(attr.getBizCode());

        BinaryOperator<Attr> bin=(v1, v2) -> v1;

        boolean a = list.stream().allMatch(s -> s.getAttr().equals("a"));
        System.out.println(a);

        String[] words = new String[]{"Hello","World"};
        List<String> la = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        la.forEach(System.out::print);

        double[] ds={(double)2};

        long count = list.stream().map(Attr::arrs).flatMap(Arrays::stream).count();
        OptionalDouble average = list.stream().map(x -> ds).flatMapToDouble(Arrays::stream).average();
        System.out.println(average.getAsDouble());
    }
}

class Attr{
    private String attr;
    private String bizCode;

    public String[] arrs(){
        return new String[]{attr,bizCode};
    }

    public Attr(String attr, String bizCode) {
        this.attr = attr;
        this.bizCode = bizCode;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }


}