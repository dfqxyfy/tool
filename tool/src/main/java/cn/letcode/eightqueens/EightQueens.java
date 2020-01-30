package cn.letcode.eightqueens;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {
    List<Pos> resList = new ArrayList();
    boolean notValid = true;

    public void allQueens() {
        addList(0, new ArrayList<>());
    }

    public void addList(int i, List<Pos> list) {
        while (notValid) {
            for (int j = 0; j < 8; j++) {
                Pos pos = new Pos(i, j);
                //System.out.println(i + "\t" + j);
                if (isValid(pos, list)) {
                    list.add(pos);
                    if (i == 7) {
                        resList = new ArrayList<>(list);
                        notValid = false;
                        return;
                    }
                    addList(i+1, list);
                    list.remove(list.size() - 1);
                }
                if(j==7){
                    return;
                }
            }
        }
    }

    private boolean isValid(Pos pos, List<Pos> list) {
        for (Pos p : list) {
            if (p.i == pos.i || p.j == pos.j || Math.abs(pos.j - p.j) == Math.abs(pos.i - p.i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] queens = new int[8][8];
        final EightQueens eightQueens = new EightQueens();
        eightQueens.allQueens();
        for (Pos p : eightQueens.resList) {
            //System.out.println(p.i + "\t" + p.j);
            queens[p.i][p.j] = 1;
        }
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens.length; j++) {
                System.out.print(queens[i][j] + "\t");
            }
            System.out.println();
        }
        ;
    }
}

class Pos {
    int i;
    int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}