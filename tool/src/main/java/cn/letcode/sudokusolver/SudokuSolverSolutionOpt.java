package cn.letcode.sudokusolver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SudokuSolverSolutionOpt {


    public void solveSudoku(char[][] board ){
        solveSudoku(board,1);
    }
    boolean b = true;
    public void solveSudoku(char[][] board ,int num) {
        if(isValid(board)){
            print(board);
        }
        //System.out.println(num);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    boolean b =false;
                    Set<Character> set = possibleSet(i, j, board);
                    if (set.size() == 0) {
                        return;
                    } else {
                        Iterator<Character> iterator = set.iterator();
                        while(iterator.hasNext()) {
                            char c = iterator.next();
                            board[i][j] = c;
                            solveSudoku(board,num+1);
                            board[i][j]='.';
                        }

                    }
                }
            }
        }

    }


    public boolean isValid(char[][] board){
        boolean flag = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.')
                    flag = false;
            }
        }
        return flag;
    }

    public Set<Character> possibleSet(int row, int col, char[][] board) {
        //行
        Set<Character> set = initSet();
        for (int i = 0; i < 9; i++) {
            set.remove(board[row][i]);
        }
        //列
        for (int i = 0; i < 9; i++) {
            set.remove(board[i][col]);
        }
        //subbox
        int m = row / 3;
        int n = col / 3;
        for (int i = m * 3; i < (m + 1) * 3; i++) {
            for (int j = n * 3; j < (n + 1) * 3; j++) {
                set.remove(board[i][j]);
            }
        }
        return set;
    }

    public Set<Character> initSet() {
        Set<Character> set = new HashSet<>();
        for (char i = '1'; i <= '9'; i++) {
            set.add(i);
        }
        return set;
    }

    private void print(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        SudokuSolverSolutionOpt sudokuSolverSolution = new SudokuSolverSolutionOpt();
        sudokuSolverSolution.solveSudoku(board);
        //sudokuSolverSolution.print(board);

    }
}
