package cn.letcode.twosum;

import java.util.HashMap;
import java.util.Map;

public class MyTwoSolution {

    public static void main(String[] args) {
        int[] cc = new int[]{-1,-2,3,0,1,2};
        int target = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<cc.length;i++){
            Integer count = map.get(i);
            if(count != null){
               count +=1;
            }else{
                count = 1;
            }
            map.put(cc[i],count);
        }
        map.forEach((k,v)->{
            int needVal = target-k;
            if(map.get(needVal)!=null && map.get(k)>0 && (
                    !k.equals(needVal)|| k.equals(needVal)&&map.get(k)>1)){
                map.put(k,map.get(k)-1);
                map.put(needVal,map.get(needVal)-1);
                System.out.println(k+"\t"+needVal);
            }
        });
    }
}
