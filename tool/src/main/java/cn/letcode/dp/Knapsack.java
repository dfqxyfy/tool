package cn.letcode.dp;

public class Knapsack {
  
    private static int N = 8;  
    private static int[] weights = {1,3,5,3,2,2,4,5};  
    private static int[] values = {10,30,40,33,20,17,35,36};  
      
    private static int totalWeight = 11;  
      
    public static void main(String[] args){  
        int[][] results = new int[N+1][totalWeight + 1];  
          
        for(int i=0;i<=N;i++){  
            for(int j=0;j<=totalWeight;j++){  
                results[i][j]=0;  
            }  
        }  
          
        for(int j=1;j<=totalWeight;j++){  
            for(int i=1;i<=N;i++){  
                if(weights[i-1] > j){  
                    results[i][j] = results[i-1][j];  
                }else{  
                    results[i][j] = max(results[i-1][j], results[i-1][j-weights[i-1]] + values[i-1]);  
                }  
            }  
            System.out.println("weight = " + j);  
            print(results);  
        }  
        System.out.println(results[N][totalWeight]);  
    }  
      
    private static void print(int[][] results){       
          
        for(int j=0;j<=totalWeight;j++){  
            System.out.print(j + "\t");  
        }  
        System.out.println();  
        for(int i=0;i<=N;i++){  
            for(int j=0;j<=totalWeight;j++){  
                System.out.print(results[i][j] + "\t");;  
            }  
            System.out.println();  
        }  
          
    }  
      
    private static int max(int a, int b){  
        return a > b ? a : b;  
    }  
}  