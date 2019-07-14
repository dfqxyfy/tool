package cn.ccs.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalTimeCcs {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZoneId zoneId=ZoneId.systemDefault();
        final Instant instant = localDateTime.atZone(zoneId).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);
    }
}
