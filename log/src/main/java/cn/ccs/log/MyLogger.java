package cn.ccs.log;

import org.apache.log4j.*;
import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.util.Enumeration;

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
    }
}
