package cn.ccs.bit;

public class TestBitOpt {
    public boolean isOdd(int num) {
        return num>>1<<1 != num;
    }

    public boolean isOdd2(int num){
        return (num&1)==1;
    }
}
