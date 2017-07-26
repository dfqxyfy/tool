package cn.ccs.spi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class FileSearch implements Search {
    @Override
    public List serch(String keyword) {
        System.out.println(this.getClass().getClassLoader() +"  FileSearch... "+keyword);
        List<String> list = new ArrayList();
        list.add("abFile");
        return list;
    }
}
