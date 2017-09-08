package pl.kamilj.webLibrary.application.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static Date convertToDate(LocalDate birthday){
        return Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
