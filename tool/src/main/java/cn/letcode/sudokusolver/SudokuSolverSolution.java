package cn.letcode.sudokusolver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SudokuSolverSolution {

    int count = 0;

    public void solveSudoku(char[][] board) {
        System.out.println("**********************" + ++count);
        print(board);
        System.out.println("**********************" + ++count);
        boolean b = true;
        //while (b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    b = false;
                    Set<Character> set = possibleSet(i, j, board);
                    Iterator<Character> iterator = set.iterator();
                    if (set.size() == 0) {
                        System.out.println(""+i+"\t"+j);
                        return;
                    } else {
                        //board[i][j] = iterator.next().charValue();
                        if (iterator.hasNext()) {
                            char[][] tempboard = new char[9][9];

                            System.arraycopy(board, 0, tempboard, 0, 9);
                            tempboard[i][j] = iterator.next().charValue();
                            //System.out.println(""+i+" "+j +" " + set.size());
                            //print(tempboard);
                            solveSudoku(tempboard);
                        }
                    }
                }
            }
        }
        //}

        if (b) {
            System.out.println(">>>>>>>>>>>>>>>>>result>>>>>>>>>>>>>>>");
            print(board);
        }
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
        System.out.println("*******");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("*******");
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        char[][] tempboard = new char[9][9];
//        System.arraycopy(board, 0, tempboard, 0, 9);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }

        new SudokuSolverSolution().solveSudoku(board);
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
