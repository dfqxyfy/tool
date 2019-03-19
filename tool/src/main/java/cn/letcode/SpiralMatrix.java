package cn.letcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            list.addAll(order(matrix,i,matrix.length-i-1,i,matrix[0].length-i-1));
        }
        return list;
    }
    private List<Integer> order(int[][] matrix,int rowStart,int rowEnd,int colStart,int colEnd){
        List<Integer> list = new ArrayList<>();
        if(rowStart>rowEnd || colStart>colEnd){
            return new ArrayList<>();
        }

        for(int i=colStart;i<=colEnd;i++){
            list.add(matrix[rowStart][i]);
        }
        for(int i=rowStart+1;i<=rowEnd;i++){
            list.add(matrix[i][colEnd]);
        }
        if(rowStart<rowEnd && colStart<colEnd) {
            for (int i = colEnd - 1; i >= colStart; i--) {
                list.add(matrix[rowEnd][i]);
            }
            for (int i = rowEnd - 1; i > rowStart; i--) {
                list.add(matrix[i][colStart]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 2, 3 ,1},
                { 4, 5, 6 ,1},
                { 7, 8, 9 ,1}
        };
        List<Integer> integers = new SpiralMatrix().spiralOrder(matrix);
        for(Integer c:integers){
            System.out.print(c+" ");
        }
    }
}
