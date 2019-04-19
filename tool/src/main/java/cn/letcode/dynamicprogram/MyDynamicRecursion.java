package cn.letcode.dynamicprogram;

public class MyDynamicRecursion {

    int maxValue=0;
    int[][] arr;
    public int jump(int[][] arr) {
        this.arr = arr;
        recursion(2,2);

        return maxValue;
    }

    public int recursion(int row,int col){
        if(row<0||col<0){
            return 0;
        }
        int curVal = arr[row][col];
        if(row==0&& col==0){
            return curVal;
        }
        int rowVal =  curVal + recursion(row-1,col);
        int colVal = curVal + recursion(row,col-1);
        System.out.println(rowVal);
        System.out.println(colVal);
        if(rowVal>maxValue){
            maxValue=rowVal;
        }
        if(colVal>maxValue){
            maxValue=colVal;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 1, 10,}, {5, 4, 1}, {1, 1, 1}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(new MyDynamicRecursion().jump(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
