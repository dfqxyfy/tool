package cn.letcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniquePathsSolution {
    private int count=0;
    public int uniquePaths2(int m, int n) {
        move(0,0,m-1,n-1);
        return count;
    }
    public void move(int x,int y,int m,int n){
        if(x>m||y>n){
            return;
        }
        if(x==m&&y==n){
            count++;
            return;
        }

        if(x<m) {
            move(x + 1, y, m, n);
        }
        if(y<n) {
            move(x, y + 1, m, n);
        }
    }

    public int uniquePaths3(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int finishRow = n - 1, finishCol = m - 1;
        int[][] moves = {{0,1}, {1,0}};
        int[][] paths = new int[n][m];
        paths[finishRow][finishCol] = 1;
        for( int row = finishRow; row >= 0; row--) {
            for ( int col = finishCol; col >= 0; col--) {
                for(int[] move : moves) {
                    if(row + move[0] <= finishRow && col + move[1] <= finishCol) {
                        paths[row][col] += paths[row + move[0]][col + move[1]];
                    }
                }
            }
        }
        for(int i=0;i<paths.length;i++){
            for(int j=0;j<paths[0].length;j++){
                System.out.print(paths[i][j]+"\t");
            }
            System.out.println();
        }
        return paths[0][0];
    }

    public int uniquePaths(int m, int n) {
        int count = 0;
        int rowLimit=m-1;
        int colLimit=n-1;
        for(int i=0;i<rowLimit;i++){
            for(int j=0;j<colLimit;j++){
                for(int k=0;k<2;k++){
                    //if()
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        int i = new UniquePathsSolution().uniquePaths3(3, 2);
        long t2 = System.nanoTime();
        System.out.println((t2-t1));
        System.out.println((t2-t1));
        System.out.println(i);
    }
}
class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "(" +
                 x +
                ","+  y +
                ")";
    }
}
