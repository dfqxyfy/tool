package cn.ccs.spi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class DataSearch implements Search {
    @Override
    public List serch(String keyword) {
        System.out.println("DataSearch... "+keyword);
        List<String> list = new ArrayList();
        list.add("abData");
        return list;
    }
}
