package im.lot.yi.util;

import java.util.Date;

public abstract class DateUtils {
    public DateUtils() {
    }

    public static Date clone(Date date) {
        return date == null?null:new Date(date.getTime());
    }
}
