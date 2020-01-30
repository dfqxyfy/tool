package cn.letcode.jumpgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JumpGameSolution {
    public boolean canJump(int[] nums) {
        return jump(0,nums);
    }

    public boolean jump(int pos,int[] nums){
        if(pos+nums[pos]>=nums.length-1){
            return true;
        }
        for(int i=pos+1;i<=pos+nums[pos]&&i<nums.length;i++){
            if(jump(i,nums)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,0,4};
        nums=new int[]{2,0,0};
        //nums=new int[]{2,3,1,1,4};
        nums=new int[]{0};
        String s = "";

        BufferedReader br= null;
        try {
            File f = new File("aa");
            System.out.println(f.getAbsolutePath());
            br = new BufferedReader(new FileReader("/project/tool/tool/src/main/resources/jumpgame_val.dat"));
            s=br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] split = s.split(",");
        nums=new int[split.length];
        for(int i=0;i<split.length;i++){
            nums[i]=Integer.valueOf(split[i]);
        }
        System.out.println(nums.length);
        //当前JSON共 25003 个Key，大于预设值10000，已取消自动格式化；可到FeHelper设置页调整此配置！
        boolean b = new JumpGameSolution().canJump(nums);
        System.out.println(b);
    }
}
