package cn.letcode.dynamicprogram;

public class MyDynamic {

    public int jump(int[][] arr) {

        int cur = 0;
        int row = arr.length;
        int col = arr[0].length;
        while (cur < row && cur < col) {

            int curRow = Math.min(cur + 1, row - 1);
            int curCol = Math.min(cur + 1, col - 1);
            //先列
            if ((cur + 1) < row) {
                for (int i = 0; i < curRow; i++) {
                    if (i == 0) {
                        arr[i][cur + 1] += arr[i][cur];
                    } else {
                        arr[i][cur + 1] += Math.min(arr[i - 1][cur + 1], arr[i][cur]);
                    }
                }
            }
            if ((cur + 1) < col) {
                for (int i = 0; i < curCol; i++) {
                    if (i == 0) {
                        arr[cur + 1][0] += arr[cur][0];
                    } else {
                        arr[cur + 1][i] += Math.min(arr[cur + 1][i - 1], arr[cur][i]);
                    }
                }
            }
            int minRow = Math.min(cur + 1, row);
            int minCol = Math.min(cur + 1, col);
            if (cur > 0 && minCol > 0 && minRow > 0 && minRow< row && minCol <col) {
                System.out.println(minRow+" "+minCol);
                arr[minRow][minCol] += Math.min(arr[minRow - 1][minCol], arr[minRow][minCol - 1]);
            }
            //再行
            cur++;
        }

        return arr[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 1, 10,}, {5, 4, 1}, {1, 1, 1}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(new MyDynamic().jump(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
