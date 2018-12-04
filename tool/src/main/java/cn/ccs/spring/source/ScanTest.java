package cn.ccs.spring.source;

import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2017/5/10.
 */
@Component
public class ScanTest {
    private String str;

    public String getStr() {
        return str+":aaaaaaaaaaa";
    }

    public void setStr(String str) {
        this.str = str;
    }
}
