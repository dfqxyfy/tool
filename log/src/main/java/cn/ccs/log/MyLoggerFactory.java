package cn.ccs.log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class MyLoggerFactory implements LoggerFactory {
    public MyLoggerFactory(){
        System.out.println("MyLoggerFactory init .................");
    }
    public Logger makeNewLoggerInstance(String name) {

        System.out.println("myown loggerFactory .......");
        return new CcsLogger(name);
    }
}
