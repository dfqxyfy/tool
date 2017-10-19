package cn.ccs.log;

import org.apache.log4j.Logger;


public class SimpleLogger {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(SimpleLogger.class);
        logger.info("abcd");

        Logger logger2 = Logger.getLogger("3333333333333333");
        logger2.info("abccc");
    }
}
