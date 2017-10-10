package cn.ccs.log;

import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {
    public int decide(LoggingEvent event) {
        System.out.println("filter ........");
        event.getMessage();
        return Filter.ACCEPT;
    }
}
