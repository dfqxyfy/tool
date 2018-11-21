package cn.ccs.java8;

import java.util.List;

/**
 * @author ccs
 */
public class FunInterface {
    public static void main(String[] args) {

        /**
         * 1、lambda表达式
         * 这种形式最为直观，lambda表达式，接收一个String类型的参数，返回一个String类型的结果。
         * 完全符合函数式接口FunctionInterfaceTest的定义
         */
        FunctionInterfaceTest functionInterfaceTest1 = item -> item+1;
        String input = functionInterfaceTest1.getInfo("input\t");
        System.out.println(input);
        /**
         * 2、方法引用
         * Main方法当中的getInstance和getMessage方法接收一个参数，返回一个结果。符合函数式接口
         * FunctionInterfaceTest的定义。
         * 函数式接口只是定义了个方法的约定（接收一个String类型的参数，返回一个String类型的结果），
         * 而对于方法内部进行何种操作则并没有做任何的限制。在这点上，跟java以前的版本中的实现类与接口之间的
         * 关系很类似。不同的是，函数式接口更偏重于计算过程，约束了一个计算过程的输入和输出。
         * 这种约束计算过程的输入和输出的形式的好处可以看一下joinStr方法。
         */
        FunctionInterfaceTest functionInterfaceTest2 = FunInterface::getInstance;  //方法引用

        String aaaa = functionInterfaceTest2.getInfo("aaaa");
        System.out.println(aaaa);


        String msg1 = joinStr("你好",functionInterfaceTest2); //输出：你好！世界
        System.out.println(msg1);

        //还有更简单的写法,高度抽象化，具体处理由使用者自己决定
        String msg3 = joinStr("你好",item ->item+"！世界"); //输出：你好！世界
        System.out.println(msg3);

        /**
         * 3、构造方法引用
         * 构造函数的结构：接收输入参数，然后返回一个对象。这种约束跟函数式接口的约束很像。
         * 所以只要“输入参数类型”与“输出参数类型”跟FunctionInterfaceTest中的方法约束相同，
         * 就可以创建出FunctionInterfaceTest接口的实例，如下，String的构造方法中有
         * new String(str)的构造方法，所以可以得到实例。
         * 这里存在一个类型推断的问题，JDK的编译器已经帮我们自动找到了只有一个参数，且是String类型的构造方法。
         * 这就是我们直接String::new，没有指定使用哪一个构造方法，却可以创建实例的原因
         */
        FunctionInterfaceTest functionInterfaceTest4 = String::new; //方法引用

        String aa = functionInterfaceTest4.getInfo("aa");
        System.out.println(aa);

        TestFunction testFunction = new ExTestFunction();
        String dd = testFunction.deal(sss -> {
                return "abcde" + 3333;
        });
        System.out.println(dd);

        FunIntTest funIntTest = item->item.length();
        Integer len = funIntTest.changeValue("adfafas");
        System.out.println(len);

        testFunction.change(item->{
            int i = item.length() * 2 + 10;
            System.out.println(i);
            return i;
        });
        int change = testFunction.change(str ->
                str.length() * 2 + 1000
        );
        System.out.println(change);
    }

    public static String getInstance(String item){
        return item+"！世界";
    }

    public static String getMessage(String massage){
        return "世界,"+ massage+"!";
    }

    public  static String joinStr(String str,FunctionInterfaceTest functionTest){
        return functionTest.getInfo(str);
    }

}

@FunctionalInterface
interface FunctionInterfaceTest{
    String getInfo(String input);
}

@FunctionalInterface
interface FunIntTest{
    Integer changeValue(String input);
}

abstract class TestFunction{
    String deal(FunctionInterfaceTest de){

        return de.getInfo("aaa");
    }

    abstract  int change(FunIntTest funTest);
}

class ExTestFunction extends TestFunction{
    @Override
    int change(FunIntTest funTest){
        return funTest.changeValue("333");
    }
}