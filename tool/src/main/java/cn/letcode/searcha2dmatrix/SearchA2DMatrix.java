package cn.letcode.searcha2dmatrix;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        int row=0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]>target){
                break;
            }
            row=i;
        }
        for(int j=0;j<matrix[row].length;j++){
            if(matrix[row][j]==target){
                return true;
            }else{
                if(matrix[row][j]>target){
                    return false;
                }
            }
        }
        return false;
    }
}
