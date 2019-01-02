package cn.ccs.hash;

public class TestChar4 {
    public static void main(String []args){
        System.out.println('1');
        System.out.println('A');
        System.out.println('中');
        System.out.println(' ');
        //System.out.println('');//编译错误，空字面量
        //System.out.println('美国');//编译错误，字符太多了，对于字符字面量而言

        char max = (char)(Character.MAX_VALUE+1);
        System.out.println(max);

        char min = (char)(Character.MIN_VALUE-1);
        System.out.println(min);

        char a = 49;
        System.out.println(a);

        char b = 65535;
        //char b1 = 65536;//编译不通过，报必须是char类型的却发现为int类型的

        System.out.println(b);
        char c = 0;
        //char c1 = -1;//编译不通过，报必须是char类型的却发现为int类型的
        System.out.println(c);

        char d = '1'+1;
        System.out.println(d);

        char e = '1'+'1';
        System.out.println(e);

        char f = '国'+1;
        System.out.println(f);
    }
}