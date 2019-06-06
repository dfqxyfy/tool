package cn.letcode.jumpgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Opt2JumpGameSolution {
    public boolean canJump(int[] nums) {
        int pos = 0;
        int farrest = pos + nums[pos];
        int len = nums.length;
        for (int i = 1; i <= farrest && i<len; i++) {
            if (farrest < i + nums[i]) {
                farrest = i + nums[i];
            }
        }
        if (farrest >= nums.length - 1) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 0, 4};
        nums = new int[]{2, 0, 0};
        nums = new int[]{2, 3, 1, 1, 4};
//        nums=new int[]{0};
//        nums = getValFromFile();
        //当前JSON共 25003 个Key，大于预设值10000，已取消自动格式化；可到FeHelper设置页调整此配置！
        boolean b = new Opt2JumpGameSolution().canJump(nums);
        System.out.println(b);
    }

    public static int[] getValFromFile() {
        String s = "";

        BufferedReader br = null;
        try {
            File f = new File("aa");
            System.out.println(f.getAbsolutePath());
            br = new BufferedReader(new FileReader("/project/tool/tool/src/main/resources/jumpgame_val.dat"));
            s = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        return nums;
    }
}
