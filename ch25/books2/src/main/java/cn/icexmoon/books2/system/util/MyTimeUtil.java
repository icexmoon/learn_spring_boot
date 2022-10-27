package cn.icexmoon.books2.system.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.system.util
 * @ClassName : .java
 * @createTime : 2022/10/25 17:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyTimeUtil {
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final DateTimeFormatter DAY_HH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String convert2timeStrWithNoSeconds(LocalDateTime time){
        if (null == time) {
            return "0000-00-00 00:00";
        }
        return DAY_HH_MM.format(time);
    }

    public static String convert2timeStr(LocalDateTime time) {
        if (null == time) {
            return "0000-00-00 00:00:00";
        }
        return timeFormatter.format(time);
    }

    public static String convert2DayStr(LocalDateTime time) {
        if (null == time) {
            return "0000-00-00";
        }
        return dayFormatter.format(time);
    }

    public static String convert2DayStr(LocalDate date) {
        if (null == date) {
            return "0000-00-00";
        }
        return dayFormatter.format(date);
    }

    /**
     * 将时间字符串转换为LocalDateTime
     *
     * @param time 时间字符串
     * @return
     */
    public static LocalDateTime convert2DateTime(String time) {
        return LocalDateTime.parse(time, timeFormatter);
    }

    /**
     * 将日期字符串转换为LocalDate
     *
     * @param time 日期字符串
     * @return
     */
    public static LocalDate convert2Date(String time) {
        return LocalDate.parse(time, dayFormatter);
    }

    public static String timeDurationStr(LocalDateTime time1, LocalDateTime time2) {
        if (time1 == null || time2 == null) {
            return "--";
        }
        return convert2str(Duration.between(time1, time2));
    }

    /**
     * 将时间间隔转换为合适的字符串
     *
     * @param duration 时间间隔
     * @return
     */
    public static String convert2str(Duration duration) {
        long days = Math.abs(duration.toDays());
        if (days > 0) {
            //对于大于1天的时间间隔，用X天X小时表达
            long hours = Math.abs(duration.toHours());
            hours -= days * 24;
            return String.format("%d天%d小时", days, hours);
        }
        long hours = Math.abs(duration.toHours());
        if (hours > 0) {
            //小于1天，大于1小时的时间间隔，用X小时X分表达
            long minutes = Math.abs(duration.toMinutes());
            minutes -= hours * 60;
            return String.format("%d小时%d分", hours, minutes);
        }
        long minutes = Math.abs(duration.toMinutes());
        if (minutes > 0) {
            //小于1小时大于1分钟的时间间隔，用X分X秒来表示
            long seconds = Math.abs(duration.getSeconds());
            seconds -= minutes * 60;
            return String.format("%d分%d秒", minutes, seconds);
        }
        //剩余情况都显示X秒
        long seconds = Math.abs(duration.getSeconds());
        return String.format("%d秒", seconds);
    }

    public static String queryDateFormat(LocalDateTime date, String format) {
        if (null == date) {
            return "0000-00-00";
        }
        return format == null ? DAY_HH_MM.format(date) : DateTimeFormatter.ofPattern(format).format(date);
    }

    public static String queryDateFormat(LocalDateTime date) {

        return queryDateFormat(date, null);
    }
}