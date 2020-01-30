package cn.letcode.nqueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    int n;
    private List<List<Pos>> resList = new ArrayList<>();

    private int num;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        if(n==0){
            return new ArrayList<>();
        }
        nQueens(new ArrayList<>());
        num=resList.size();
        return changePos2Str();
    }

    public List<List<String>> changePos2Str(){
        List<List<String>> list = new ArrayList<>();
        for(List<Pos> lp:resList){
            int[][] qn=new int[n][n];
            for(Pos p:lp){
                qn[p.x][p.y]=1;
            }
            List<String> sList=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder strb = new StringBuilder();

                for(int j=0;j<n;j++){
                    if(qn[i][j]==0){
                        strb.append(".");
                    }else{
                        strb.append("Q");
                    }
                }
                sList.add(strb.toString());
            }
            list.add(sList);
        }
        return list;
    }

    public void nQueens(List<Pos> list){
        if(list.size()==n){
            resList.add(list);
            return ;
        }
        for(int i=0;i<n;i++){
            List<Pos> templist=new ArrayList<>(list);
            Pos pos = new Pos(list.size(),i);
            if(isValid(templist,pos)){
                templist.add(pos);
                nQueens(templist);
            }
        }
    }

    private boolean isValid(List<Pos> list ,Pos pos){
        for(Pos p:list){
            if(p.x==pos.x ||p.y==pos.y|| Math.abs(p.x-pos.x)==Math.abs(p.y-pos.y)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
        System.out.println(nQueens.num);
    }


}
class Pos{
    int x;
    int y;
    Pos(int x,int y){
        this.x=x;
        this.y=y;
    }
}
