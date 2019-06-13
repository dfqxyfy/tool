package cn.letcode.searcha2dmatrix;

public class BinarySolution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row;
        int start=0;
        int end=matrix[0].length-1;
        while(end>start){
            row=(start+end+1)/2;
            if(target<matrix[row][0]){
                start=row;
            }else if(target==matrix[row][0]){
                break;
            }else if(target>matrix[row][0]){
                end=row;
            }
        }

        return false;
    }
}
