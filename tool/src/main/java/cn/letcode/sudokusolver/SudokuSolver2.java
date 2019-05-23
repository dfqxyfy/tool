package cn.letcode.sudokusolver;

public class SudokuSolver2 {
    private char[][] board;
    private char[][] dotsCoordinate = new char[81][2];
    private boolean[][][] flags = new boolean[3][9][10];
    private int lenOfDots;

    public void solveSudoku(char[][] board) {
        this.board = board;
        int digit, idxOfBlocks;
        for (char i = 0; i < 9; i++) {
            for (char j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    dotsCoordinate[lenOfDots][0] = i;
                    dotsCoordinate[lenOfDots][1] = j;
                    lenOfDots++;
                } else {
                    digit = board[i][j] - '0';
                    flags[0][i][digit] = true;
                    flags[1][j][digit] = true;
                    idxOfBlocks = i / 3 * 3 + j / 3;
                    flags[2][idxOfBlocks][digit] = true;
                }
            }
        }
        solveSudokuHelper(0);
    }

    private boolean solveSudokuHelper(int start) {
        if (start == lenOfDots) {
            return true;
        }

        char j, k;
        int idxOfBlocks;
        for (char i = 1; i < 10; i++) {
            j = dotsCoordinate[start][0];
            k = dotsCoordinate[start][1];
            idxOfBlocks = j / 3 * 3 + k / 3;
            if (flags[0][j][i] || flags[1][k][i] || flags[2][idxOfBlocks][i]) {
                continue;
            }
            flags[0][j][i] = true;
            flags[1][k][i] = true;
            flags[2][idxOfBlocks][i] = true;
            board[j][k] = (char) ('0' + i);
            if (solveSudokuHelper(start + 1)) {
                return true;
            }
            board[j][k] = '.';
            flags[0][j][i] = false;
            flags[1][k][i] = false;
            flags[2][idxOfBlocks][i] = false;
        }
        return false;
    }
}
