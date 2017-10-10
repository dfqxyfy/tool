package cn.ccs.log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;


public class SimpleLogger {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(SimpleLogger.class);
        logger.info("abcd");
    }
}
