package cn.ccs.spi;

import java.util.List;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class SearchTest {
    public static void main(String[] args) {
        List<Search> list = SearchFactory.newSearch();
        list.forEach(search ->{
            search.serch("java spi test");
        });
    }
}