package cn.letcode.spiralmatrixii;

public class SpiralMatrixIISolution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];

        int dept = 0;
        int count = 1;
        while (count <= n * n) {
            for (int i = dept; i < n - dept; i++) {
                nums[dept][i] = count++;
            }
            for (int i = dept + 1; i < n - dept; i++) {
                nums[i][n - dept - 1] = count++;
            }
            for (int i = n - dept - 2; i >= dept; i--) {
                nums[n - dept - 1][i] = count++;
            }
            for (int i = n - dept - 2; i > dept; i--) {
                nums[i][dept] = count++;
            }
            dept++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] nums = new SpiralMatrixIISolution().generateMatrix(3);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
