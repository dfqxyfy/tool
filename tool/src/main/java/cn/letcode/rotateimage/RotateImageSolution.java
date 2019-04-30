package cn.letcode.rotateimage;

public class RotateImageSolution {
    public void rotate(int[][] matrix) {
        int half = (matrix.length) / 2;
        int n = matrix.length - 1;
        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
        if (matrix.length % 2 == 1) {
            for (int i = 0; i < half; i++) {
                int j = half;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        matrix= {{ 5, 1, 9,11},
//              { 2, 4, 8,10},
//              {13, 3, 6, 7},
//              {15,14,12,16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("*********");
        new RotateImageSolution().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
