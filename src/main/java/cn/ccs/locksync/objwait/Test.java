package cn.ccs.locksync.objwait;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();
        Producer pro = new Producer(list);
        Connsumer con = new Connsumer(list);
        for (int i = 0; i <= 1; i++) {
            new Thread(pro).start();
            new Thread(con).start();
            new Thread(con).start();
        }
    }
}