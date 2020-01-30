package cn.letcode.jumpgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCodeSolution {
    public List<Integer> grayCode(int n) {
        List out = new LinkedList<>();
        for (int i = 0; i < Math.pow(2,n); i++) out.add(i ^ i>>1);
        return out;
    }

    public static void main(String[] args) {
        List<Integer> integers = new GrayCodeSolution().grayCode(4);
        System.out.println(integers);
    }
}
