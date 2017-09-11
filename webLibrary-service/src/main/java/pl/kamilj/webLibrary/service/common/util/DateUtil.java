package pl.kamilj.webLibrary.service.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static Date convertToDate(LocalDate birthday) {
        return Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String convertToString(Date dateToConvert) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(dateToConvert);
    }
}
