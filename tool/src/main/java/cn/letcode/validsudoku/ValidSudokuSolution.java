package cn.letcode.validsudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudokuSolution {
    public boolean isValidSudoku(char[][] board) {
        //按行来看
        for(int i=0;i<board.length;i++){
            Set<Character> set = new HashSet<>();
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.')
                    continue;
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        //按列来看
        for(int j=0;j<board[0].length;j++){
            Set<Character> set = new HashSet<>();
            for(int i=0;i<board[0].length;i++){
                if(board[i][j]=='.')
                    continue;
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int col=i*3;
                int row=j*3;
                Set<Character> set = new HashSet<>();
                for(int m=row;m<row+3;m++) {
                    for(int n=col;n<col+3;n++){
                        if(board[m][n]=='.')
                            continue;
                        if(set.contains(board[m][n])){
                            return false;
                        }
                        set.add(board[m][n]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =new char[][]{
                {'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(new ValidSudokuSolution().isValidSudoku(board));
    }

}
