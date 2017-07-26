package cn.ccs.spi;

import java.util.List;

/**
 * Created by chaichuanshi on 2017/5/15.
 */
public class SearchTest {
    public static void main(String[] args) {
        System.out.println("System: "+System.getProperty("sun.boot.class.path"));
        System.out.println("Ext: "+System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("App: "+"java.class.path"));
        System.out.println("String: "+String.class.getClassLoader());
        System.out.println("SearchFactory: "+SearchFactory.class.getClassLoader());
        Search s = new DataSearch();
        s.serch("33");
        System.out.println(SearchTest.class.getClassLoader());
        List<Search> list = SearchFactory.newSearch();
        list.forEach(search ->{
            search.serch("java spi test");
        });
    }
}