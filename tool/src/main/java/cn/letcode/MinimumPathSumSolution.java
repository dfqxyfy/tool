package cn.letcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumPathSumSolution {
    private int minVal = -1;
    private List<Integer> resultList = new ArrayList<>();

    public int minPathSum2(int[][] grid) {
        //int innerVal = grid[0][0];
        val(grid, 0, 0, 0, new ArrayList<Integer>());
        return minVal;
    }

    private void val(int[][] grid, int row, int col, int subVal, List<Integer> list) {
        int total = subVal + grid[row][col];
        list.add(grid[row][col]);

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (minVal < 0) {
                minVal = total;
                resultList = list;
            }
            if (total < minVal) {
                minVal = total;
                //System.out.println(total);
                resultList = list;
            }
        }
        if (row + 1 < grid.length) {
            val(grid, row + 1, col, total, new ArrayList<Integer>(list));
        }
        if (col + 1 < grid[0].length) {
            val(grid, row, col + 1, total, new ArrayList<Integer>(list));
        }
    }


    public int minPathSum3(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = grid[i][j];
                } else if (i == 0) {
                    arr[i][j] = arr[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + grid[i][j];
                } else {
                    arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr[n - 1][m - 1];
    }


    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = grid[i][j];
                }
                if ((i == 0 || i == (row - 1)) && j > 0 && j < col) {
                    arr[i][j] = arr[i][j-1] + grid[i][j];
                }
                if ((j == 0 || j == (col - 1)) && i > 0 && i < row) {
                    arr[i][j] = arr[i-1][j] + grid[i][j];
                }
                if (j > 0 && j < col && i > 0 && i < row) {
                    arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

//        grid = new int[][]{{7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5}, {9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6}, {8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8}, {6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4}, {7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4}, {9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9}, {1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4}, {3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2}, {1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3}, {5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7}, {2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7}, {0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9}};
        MinimumPathSumSolution minimumPathSumSolution = new MinimumPathSumSolution();
        int i = minimumPathSumSolution.minPathSum(grid);
        minimumPathSumSolution.resultList.forEach(c -> {
            System.out.print(c + "\t");
        });
        System.out.println();
        System.out.println(i);
    }
}
