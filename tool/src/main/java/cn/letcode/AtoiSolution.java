package cn.letcode;

public class AtoiSolution {
    public int myAtoi(String str) {
        String splits[] = str.split(" ");
        for(int i=0;i<splits.length;i++){
            if(splits[i].matches("-?\\d+")){
                try {
                    return Integer.valueOf(splits[i]);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        AtoiSolution atoiSolution = new AtoiSolution();
        int i = atoiSolution.myAtoi("words and 9811111111111111117");
        System.out.println(i);ThreadLocal l;
    }

}
