package cn.ccs.springanno;

import cn.ccs.spring.anno.MyClassAnno;
import cn.ccs.spring.anno.MyMethodAnno;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Created by chaichuanshi on 2016/10/28.
 */
@Component
@MyClassAnno
public class Processor {
    private static int count = 0;
    private int cc = 0;
    public Processor(){
        ++count;
        System.out.println("第 "+  count +" 个 processor");
        this.cc = count;
    }

    @MyMethodAnno
    public void proc(){
        System.out.println("proc");
    }


    public int getCount(){

        MessageFormat mf = new MessageFormat("");
        MessageFormat.format("","","");

        String s = "";
        return cc;
    }

}
