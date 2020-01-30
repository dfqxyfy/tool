package cn.letcode.spiralmatrixpack;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private List<Integer> resList = new ArrayList();
    private int[][] matrix;

    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;

        if (matrix.length == 0)
            return resList;

        int re=matrix.length-1;
        int ce=matrix[0].length-1;
        print(0, re, 0, ce);
        return resList;
    }

    private void print(int rs, int re, int cs, int ce) {
        if(cs>ce||rs>re){
            return;
        }
        for (int i = cs; i <= ce ; i++) {
            resList.add(matrix[rs][i]);
        }
        for (int i = rs+1; i <= re ; i++) {
            resList.add(matrix[i][ce]);
        }
        if (cs < ce && rs < re) {
            for (int i = ce-1; i > cs; i--) {
                resList.add(matrix[re][i]);
            }
            for (int i = re; i > rs; i--) {
                resList.add(matrix[i][cs]);
            }
        }

        print(rs + 1, re - 1, cs + 1, ce - 1);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},


                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {7, 8, 9},



//                {1,2,3,4,5,6,7,8,9,10},
//                {11,12,13,14,15,16,17,18,19,20},
        };

        List<Integer> integers = new SpiralMatrix().spiralOrder(matrix);
        for(Integer i:integers){
            System.out.print(i+"\t");
        }
    }
}
