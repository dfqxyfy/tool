package cn.letcode.dp;

import java.util.*;
import java.util.stream.Collectors;

public class MaxCoins {

    Integer[] coins = new Integer[]{1,4,5};

    public int dp(int money){
        Integer[] maxConis = new Integer[money+1];

        maxConis[1]=1;
        for(int i=1;i<=money;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j] > 0) {
                    min = Math.min(min,maxConis[i-coins[j]]+1);
                }else if(i-coins[j] == 0){
                    min = 1;
                    break;
                }
            }
            if(min != Integer.MAX_VALUE)
                maxConis[i] = min;
        }
        System.out.println(String.join(",",  new ArrayList<>(Arrays.asList(maxConis)).stream()
                .map(i->String.valueOf(i)).collect(Collectors.toList())));
        return maxConis[money-1];
    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        int deep = maxCoins.dp(13);
        System.out.println(deep);


//        Stream.of(maxCoins.coins)
        List<Integer> integers = Arrays.asList(maxCoins.coins);


    }
}
