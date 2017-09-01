package cn.ccs.spring.duplicatebean;

import cn.ccs.spring.anno.MyClassAnno;
import cn.ccs.spring.anno.MyMethodAnno;
import org.springframework.stereotype.Component;

/**
 * Created by chaichuanshi on 2016/10/28.
 */
@Component
public class DubProcessor {
    private static int count = 0;

    public DubProcessor(){
        System.out.println("构造 " + count++ +" 次");
    }

}
