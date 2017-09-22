package cn.ccs.log;

import org.apache.log4j.*;
import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MyLogger {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(MyLogger.class);
        final ConsoleAppender appender = new ConsoleAppender();
        appender.activateOptions();

        final SimpleLayout simpleLayout = new SimpleLayout();
        LoggingEvent myloggerEvent = new LoggingEvent("MyLogger",logger, Priority.DEBUG,"tempmsg",new RuntimeException("xxxx"));
        simpleLayout.format(myloggerEvent);

        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("[%t]%c[%d]%X\t%L%m%n");

        HTMLLayout htmlLayout = new HTMLLayout();
        htmlLayout.setTitle("aaaa");
        htmlLayout.setLocationInfo(true);

        TTCCLayout ttccLayout = new TTCCLayout("yyyy-MM-dd HH:mm:ss");
        ttccLayout.setCategoryPrefixing(false);
        ttccLayout.setCategoryPrefixing(true);

        DateLayout dateLayout = new DateLayout() {
            @Override
            public String format(LoggingEvent loggingEvent) {
                return this.date+ "*******"+loggingEvent.getMessage()+"************\n";
            }

            @Override
            public boolean ignoresThrowable() {
                return false;
            }
        };

        appender.setLayout(simpleLayout);
        appender.setLayout(patternLayout);
        appender.setLayout(htmlLayout);
        appender.setLayout(ttccLayout);
        appender.setLayout(dateLayout);

        System.out.println(appender.getFollow());
        logger.addAppender(appender);

        logger.setLevel(Level.ALL);
        logger.info("infomsg.....");
        logger.error("errormsg.....");


        Map m  = new HashMap();
        m.put("adfs","dfsafd");
        System.out.println(m);

        String str = "{\"charset\":\"UTF-8\",\"data\":\"8X5kgFRO8S%2FNS2AY356OGGNEqhJpvrfGMMhYLut%2F5XuRbCncjqAI2M4C8HgHqg14nWNG0BvNwqkv%0ABhB7ddf%2Fr52tq0e%2F8YgphJRSsbhyIwcWiOtvVDMa1ZRgLT3Q%2FXm6eYl%2F5jnkNEPC0XBO8ffENAZO%0AlsV0vkzSOOF%2B0QBJYbmjRPoKyPK1KPlHjFwg%2FSctMCF%2BqgQAbWAAmUSO%2BI1JG4rVu0luiWDM8k4k%0AMn5kdo6XIm31q3Ui%2Fw5pmELNoU3TBGZqGbvGcf8qm39Lb3MA6k3JUslCNy0IWMRQZ2ZQES064zUc%0AYRvouMCMnXPu72KG\",\"sign\":\"7bd7a355b6f46631102258bd7fafaca68ca83d4df05565f9e8ff9737f7fa3d40\",\"tradeType\":\"01\",\"version\":\"1.0\"}";
    }
}
