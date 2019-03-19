package cn.letcode;

import java.util.ArrayList;
import java.util.List;

public class Spiral2Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) {
            return ans;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2-1; c >= c1; c--) {
                    ans.add(matrix[r2][c]);
                }
                for (int r = r2-1; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 1},
                {4, 5, 6, 1},
                {7, 8, 9, 1}
        };
        List<Integer> integers = new Spiral2Matrix().spiralOrder(matrix);
        for (Integer c : integers) {
            System.out.print(c + " ");
        }
    }
}
