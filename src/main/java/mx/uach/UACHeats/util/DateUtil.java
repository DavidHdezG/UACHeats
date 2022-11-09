package mx.uach.UACHeats.util;

import java.time.format.DateTimeFormatter;

public class DateUtil {
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    static java.time.LocalDateTime now = java.time.LocalDateTime.now();

    public static String getCurrentDateTime(){
        return now.format(format);
    }
}
