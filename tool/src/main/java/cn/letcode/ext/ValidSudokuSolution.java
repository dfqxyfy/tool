package cn.letcode.ext;

public class ValidSudokuSolution {

    private char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

    public boolean isValidSudoku(char[][] board) {
        char[][] dest = new char[9][9];
        System.arraycopy(board,0,dest,9,9);
        do{
            return true;
        }while(true);

    }

    private boolean isValid(int x,int y,char val){
        int xbas = x/3;
        int ybas = y/3;
        //小单元格
        for(int i=0+xbas*3;i<(xbas+1)*3;i++){
            for(int j=0+ybas*3;j<(ybas+1)*3;j++){
                if(i!=x&&j!=y&&val==board[x][y]){
                    return false;
                }
            }
        }
        //横向
        for(int i=0;i<9;i++){
            if(i!=x&&board[i][y]==val){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(j!=y&&board[x][j]==val){
                return false;
            }
        }
        return true;
    }
}
