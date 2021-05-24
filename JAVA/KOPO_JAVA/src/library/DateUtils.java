package library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String getToday() {
        return format.format(Calendar.getInstance().getTime());
    }

    public static int diffDatesFromToday(String date) {
        try {
            Date firstDate = format.parse(date);
            Date secondDate = format.parse(getToday());
            long calDate = Math.abs(firstDate.getTime() - secondDate.getTime());
            long calDateDays = calDate / (24 * 60 * 60 * 1000);
            return (int) calDateDays;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
