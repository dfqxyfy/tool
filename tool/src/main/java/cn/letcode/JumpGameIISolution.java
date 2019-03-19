package cn.letcode;

public class JumpGameIISolution {
    public int jump(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int lastReach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i <= reach && i < A.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, A[i] + i);
        }
        if (reach < A.length - 1) {
            return 0;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 1, 10, 1, 4,5,4,1,1,1,1,1,1};
        System.out.println(new JumpGameIISolution().jump(a));
    }
}
