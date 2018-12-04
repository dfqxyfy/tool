package cn.ccs.spi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class SearchFactory {
    private SearchFactory() {
    }
    public static List<Search> newSearch() {
        List<Search> list = new ArrayList<>();
        Search search = null;
        ServiceLoader<Search> serviceLoader = ServiceLoader.load(Search.class);
        Iterator<Search> searchs = serviceLoader.iterator();
        while (searchs.hasNext()) {
            search = searchs.next();
            list.add(search);
        }
        return list;
    }
}
