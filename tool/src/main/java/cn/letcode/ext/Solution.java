package cn.letcode.ext;

class Solution {
    public void solveSudoku(char[][] board) {
        if(solveSudoku2(board)) {
            return;
        }
    }
    
    public boolean solveSudoku2(char[][] board) {
        boolean isEmpty = true;
        int row = -1;
        int col = -1;
        int n = board.length;
        
        //this code is used to check if there exists any empty cell in sudoku board
        //if there is any empty cell, that means we are not done yet and we need to solve it further,
        // so we cannot return true at any point until all the cells are full
        //by empty cell, I mean cells having '.' as the value
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
               if(board[i][j] == '.') {
                   row = i;
                   col = j;
                   isEmpty = false;
                   break;
               }
            }
            if(!isEmpty) {
                break;
            }
        }
        
        if(isEmpty) {
            return true;
        }
        
        //loop for all the numbers and start placing in the empty cells
        //numbers start from 1 to n
        
        for(int num = 1; num <= n; num++) {
            //convert number to char
            char char_num = (char)(num + '0');
            //check if the number we are adding satisfies all the sudoku rules,
            // if it does, then we place that number in the cell
            if(checkSafe(board,char_num,row,col)) {
                board[row][col] = (char)(num + '0');
                
                //using this number in place row,col, we check for all the other empty places and see if the board is returning true or not
                // if the board is not filled that means that we need to use other number in row,col place.
                //hence backtrack.
                if(solveSudoku2(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    
    public boolean checkSafe(char[][] board, char num, int row, int col) {
        //checkk if num is present in the row
        for(int i = 0; i< board.length; i++ ) {
            if(board[row][i] == num) {
                return false;
            }
        }
        
        for(int j = 0; j < board[0].length; j++) {
            if(board[j][col] == num) {
                return false;
            }
        }
        
        int checknum = (int)Math.sqrt(board.length);
        //check for the current grid. grid will be basically checknum*checknum matrix. where every matrix will start from startrow to  startrow + checknum having checknum length.
        // so, we we have row = 0, then matrix will start from 0 to 2, i.e. the first 3x3 matrix.
        // however, we have row = 2, then also the matrix will start from 0 to 2 - the first 3x3 matrix.
        //however, if row = 3, then we will start our matrix from 3 and cotinute upto 5.
        
        int startrow = row - row % checknum;
        int startcol = col - col % checknum;
        for(int k = startrow; k < startrow + checknum; k++) {
            for(int l = startcol; l < startcol + checknum; l++) {
                if(board[k][l] == num) {
                    return false;
                }   
            }
        }
        return true;
    }
}