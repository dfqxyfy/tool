package cn.letcode.spiralmatrixpack;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixSolution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        if (matrix.length == 0)
            return ans;

        int re = matrix.length - 1;
        int ce = matrix[0].length - 1;

        int rs = 0;
        int cs = 0;
        while (rs <= re && cs <= ce) {
            for (int i = cs; i <= ce; i++) {
                ans.add(matrix[rs][i]);
            }
            for (int i = rs + 1; i <= re; i++) {
                ans.add(matrix[i][ce]);
            }
            if (rs < re && cs < ce) {
                for (int i = ce - 1; i >= cs; i--) {
                    ans.add(matrix[re][i]);
                }
                for (int i = re - 1; i > rs; i--) {
                    ans.add(matrix[i][rs]);
                }
            }
            rs++;
            re--;
            cs++;
            ce--;

        }


        return ans;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},


                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {17, 18, 19},


//                {1,2,3,4,5,6,7,8,9,10},
//                {11,12,13,14,15,16,17,18,19,20},
        };

        List<Integer> integers = new SpiralMatrixSolution().spiralOrder(matrix);
        for (Integer i : integers) {
            System.out.print(i + "\t");
        }
    }
}
