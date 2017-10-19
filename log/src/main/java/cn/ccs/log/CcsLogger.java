package cn.ccs.log;

import org.apache.log4j.*;
import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

import java.util.HashMap;
import java.util.Map;

public class CcsLogger extends Logger{

    protected CcsLogger(String name) {
        super(name);
    }
}
