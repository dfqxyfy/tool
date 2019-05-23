package cn.letcode.sudokusolver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SudokuSolverSolution {

    int count = 0;
    char[][] resultBoard;

    public void solveSudoku(char[][] board ){
        solveSudoku(board,1);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=this.resultBoard[i][j];
            }
        }

    }

    public void solveSudoku(char[][] board ,int num) {
        count++;
//        System.out.println("********************** " + count+" **********************");
//        print(resultBoard);
//        System.out.println("********************** " + count+" **********************");
        boolean b = true;
        loop:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    b = false;
                    Set<Character> set = possibleSet(i, j, board);
                    Iterator<Character> iterator = set.iterator();
                    if (set.size() == 0) {
//                        System.out.println("处理过程中需要的位置位置集合冲突回退"+i+"\t"+j);
                        return;
                    } else {
                        //resultBoard[i][j] = iterator.next().charValue();
                        StringBuilder strb = new StringBuilder();
                        while(iterator.hasNext()){
                            char c = iterator.next();
                            strb.append(c).append(" ");
                        }
                        iterator = set.iterator();
//                        System.out.println("处理过程中需要的位置\t"+i+"\t"+j+"\t可能值的集合："+strb.toString());
                        while(iterator.hasNext()) {
                            char c = iterator.next();
                            board[i][j] = c;
                            char[][] tempboard = cpArray(board);
//                            System.out.println("第 "+num+" 个.值，处理过程中需要的位置\t"+i+"\t"+j+"\t可能值的集合："+strb.toString()+"\t使用值："+c);
                            solveSudoku(tempboard,num+1);
                        }

                    }
                    break loop;
                }
            }
        }
        if(b){
            this.resultBoard =board;
            return;
        }

    }

    private char[][] cpArray(char[][] board){
        char[][] tempboard= new char[board.length][board[0].length];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tempboard[i][j]=board[i][j];
            }
        }
        return tempboard;
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
//        char[][] tempboard = new char[9][9];
//
//        new SudokuSolverSolution().print(resultBoard);
//        System.arraycopy(resultBoard, 0, tempboard, 0, 9);
//        tempboard[0][0]='a';
//        new SudokuSolverSolution().print(resultBoard);
//        new SudokuSolverSolution().print(tempboard);

        SudokuSolverSolution sudokuSolverSolution = new SudokuSolverSolution();
        sudokuSolverSolution.solveSudoku(board);
        sudokuSolverSolution.print(board);

    }
}
