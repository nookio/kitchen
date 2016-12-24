package helper;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * User: dg
 * Date: 13/8/15
 * Time: 下午1:41
 */
public class DateUtil extends DateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    public final static String DefaultShortFormatWithNo = "yyyyMMdd";
    public final static String DefaultShortFormat = "yyyy-MM-dd";
    public final static String DefaultLongFormat = "yyyy-MM-dd HH:mm:ss";
    public final static String DefaultMinuteFormat = "yyyy-MM-dd HH:mm";
    private static DateFormat FORMAT = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);


    public static final int DAYS_OF_A_WEEK = 7;



    /**
     * the string format must yyyy-MM-dd
     *
     * @param str
     * @return
     * @author zhaolei
     * <p>
     * 2011-4-21
     */
    public static Date string2DateDay(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultShortFormat);
        str = StringUtils.null2Trim(str);
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            return cal.getTime();
        }
    }

    /**
     * 格式化字符串成Date.格式不正确的时候抛异常出来
     *
     * @param str must be yyyy-MM-dd
     * @return
     * @throws Exception
     * @author zhaolei
     * @created 2011-9-9
     */
    public static Date string2DateDay4Exception(String str) throws IllegalArgumentException {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultShortFormat);
        str = StringUtils.null2Trim(str);
        try{
            return formatter.parse(str);
        } catch (ParseException e){
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * the string format must yyyy-MM-dd HH:mm:ss
     *
     * @param str
     * @return
     * @author zhaolei
     * <p>
     * 2011-4-21
     */
    public static Date string2DateSecond24(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultLongFormat);
        str = StringUtils.null2Trim(str);
        String matchstr = "[0-2]\\d\\d\\d-\\d\\d-\\d\\d [0-2]\\d:[0-6]\\d";
        if (StringUtils.regexMatch(str, matchstr)) {
            str = str + ":00";
        }
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * the string format must yyyy-MM-dd HH:mm
     *
     * @param str
     * @return
     * @author zhaolei
     * <p>
     * 2011-4-21
     */
    public static Date string2DateMinute(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultMinuteFormat);
        str = StringUtils.null2Trim(str);
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * must yyyy MM dd HH mm ss
     *
     * @param str
     * @param formatString
     * @return
     * @author zhaolei
     * <p>
     * 2011-4-21
     */
    public static Date string2Date(String str, String formatString) {
        str = StringUtils.null2Trim(str);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatString);
            return formatter.parse(str);
        } catch (ParseException e) {
            return new Date();
        } catch (IllegalArgumentException e) {
            LOGGER.error("format string Illegal:{}", e);
            return null;
        }
    }

    /**
     * 字符串转日期.如果异常则返回null
     *
     * @param str          日期字符串
     * @param formatString 格式化的格式代码 yyyy MM dd HH mm ss
     * @return
     * @author zhaolei
     * @created 2011-10-26
     */
    public static Date string2Date4Null(String str, String formatString) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatString);
        str = StringUtils.null2Trim(str);
        try {
            return formatter.parse(str);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * yyyy-MM-dd
     *
     * @param date
     * @return
     * @author zhaolei
     * <p>
     * 2011-4-21
     */
    public static String Date2String(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultShortFormat);
        return formatter.format(date);
    }

    /**
     * yyyyMMdd
     *
     * @param date
     * @return
     * @author liuhujun
     * <p>
     * 2012-3-28
     */
    public static Integer Date2IntDay(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultShortFormatWithNo);
        return Integer.parseInt(formatter.format(date));
    }

    /**
     * 秒转日期
     *
     * @param seconds
     * @return
     */
    public static String secondsToString(Integer seconds) {
        return Date2String(fromUnixTime(seconds));
    }

    /**
     * @param date
     * @return yyyy-MM-dd HH:mm的字符串
     */
    public static String Date2StringMin(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultMinuteFormat);
        return formatter.format(date);
    }

    /**
     * @param date
     * @return yyyy-MM-dd HH:mm:ss的字符串
     */
    public static String Date2StringSec(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DefaultLongFormat);
        return formatter.format(date);
    }

    /**
     * @param seconds
     * @return 当前时间的秒数
     */
    public static String Date2StringSec(Integer seconds) {
        return Date2StringSec(fromUnixTime(seconds));
    }

    /**
     * must yyyy MM dd HH mm ss
     *
     * @param date
     * @param formatString
     * @return
     * @author zhaolei
     * <p>
     * 2011-4-21
     */
    public static String Date2String(Date date, String formatString) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatString);
            return formatter.format(date);
        } catch (IllegalArgumentException e) {
            LOGGER.error("format string Illegal: {}" ,e);
            return "";
        }
    }

    /**
     * 返回当前时间的秒数
     *
     * @return
     */
    public static int unixTime() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 把表转换为Date
     *
     * @param seconds
     * @return
     */
    public static Date fromUnixTime(Integer seconds) {
        return new Date(seconds * 1000L);
    }

    public static Date fromUnixTime(Long millis){
        return new Date(millis);
    }

    /**
     * @return
     */
    public static Date today() {
        return toDay(new Date());
    }

    public static Date yesterday(){
        return toYesterday(today());
    }

    public static Date toDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定日期当天的最后一秒
     *
     * @param date
     * @return
     * @author lichengwu
     * @created Sep 13, 2011
     */
    public static Date toNight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 返回开始到结束时间所有的日期
     *
     * @param startDateStr （yyyy-MM-dd） 开始时间
     * @param endDateStr   （yyyy-MM-dd） 结束时间
     * @return
     */
    public static List<String> dateBetween(String startDateStr, String endDateStr) {
        List<String> dateList = new ArrayList<String>();
        Date endDate = string2DateDay(endDateStr);
        Date startDate = string2DateDay(startDateStr);
        long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000); // 相差天数
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i <= day; i++) {
            cal.setTime(startDate);
            cal.add(Calendar.DAY_OF_MONTH, i);
            dateList.add(Date2String(cal.getTime()));
        }
        return dateList;
    }

    /**
     * 将时间转换成昨天
     *
     * @param date
     * @return
     * @author lichengwu
     * @created 2011-11-1
     */
    public static Date toYesterday(Date date) {
        return add(date, Calendar.DAY_OF_YEAR, -1);
    }

    /**
     * 将时间转换成明天
     *
     * @param date
     * @return
     * @author lichengwu
     * @created 2011-11-1
     */
    public static Date toTomorrow(Date date) {
        return add(date, Calendar.DAY_OF_YEAR, 1);
    }

    private static Date add(Date date, int field, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(field, value);
        return cal.getTime();
    }

    /**
     * 获取几天前的时间。
     * @param date
     * @param days
     * @return
     */
    public static Date toDaysBeforeOrAfter(Date date, Integer days){
        return add(date, Calendar.DAY_OF_YEAR, days);
    }

    /**
     * 得到某年某月有多少天
     *
     * @param year
     * @param month
     * @return
     * @author zhaolei
     * @created 2011-11-1
     */
    public static int getMonthDays(Integer year, Integer month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到年份
     *
     * @param date
     * @return
     * @author zhaolei
     * @created 2011-11-8
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        return cal.get(Calendar.YEAR);
    }

    /**
     * 得到月份
     *
     * @param date
     * @return
     * @author zhaolei
     * @created 2011-11-8
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到某天的星期.1~~7
     *
     * @param date
     * @return
     * @author zhaolei
     * @created 2011-11-9
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int rel = 0;
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                rel = 1;
                break;
            case Calendar.TUESDAY:
                rel = 2;
                break;
            case Calendar.WEDNESDAY:
                rel = 3;
                break;
            case Calendar.THURSDAY:
                rel = 4;
                break;
            case Calendar.FRIDAY:
                rel = 5;
                break;
            case Calendar.SATURDAY:
                rel = 6;
                break;
            default:
                rel = 7;
                break;
        }
        return rel;
    }

    /**
     * 日期（天）转unixtime
     *
     * @param day
     * @return
     * @author liuhujun
     * @created 2012-03-15
     */
    public static int day2Unixtime(String day) {
        return (int) (DateUtil.string2DateDay(day).getTime() / 1000L);
    }

    /**
     * date转unixtime
     *
     * @param date
     * @return
     * @author liuhujun
     * @created 2012-06-15
     */
    public static int date2Unixtime(Date date) {
        return (int) (date.getTime() / 1000L);
    }

    /**
     * 得到时间
     *
     * @param date
     * @return
     * @author chenchun
     * @created 2011-11-15
     */
    public static Date toTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }


    public static Long getFirstDayOfWeek(Long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return cal.getTimeInMillis();
    }


    public static Long getFirstDayOfMonth(Long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        cal.set(Calendar.DAY_OF_MONTH, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }

    public static Date getFirstDayOfMonth(Date date) {
        long time = getFirstDayOfMonth(date.getTime());
        return new Date(time);
    }


    public static Long getStartOfDay(Long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static Date getStartOfDay(Date date) {
        long time = getStartOfDay(date.getTime());
        return new Date(time);
    }


    public static Long getEndOfDay(Long date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    public static Date getEndOfDay(Date date) {
        long time = getEndOfDay(date.getTime());
        return new Date(time);
    }

    public static Long getLastDayOfMonth(Long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }

    public static Date getLastDayOfMonth(Date date) {
        long time = getLastDayOfMonth(date.getTime());
        return new Date(time);
    }

    public static Long getLastDayOfWeek(Long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_WEEK));
        return cal.getTimeInMillis();
    }

    /**
     * 两个日期间相差的天数
     *
     * @param start
     * @param end
     * @return
     */
    public static int getBetweenDayNum(Date start, Date end) {
        if (start == null || end == null || start.after(end)) {
            return -1;
        }

        int count = 0;
        Date date = DateUtils.truncate(start, Calendar.DATE);
        while (end.after(date)) {
            count++;
            date = DateUtils.addDays(date, 1);
        }

        return count;
    }

    /**
     * 指定日期当天的最后一秒
     *
     * @param date
     * @return
     * @author lichengwu
     * @created Sep 13, 2011
     */
    public static Date toLastSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 指定日期当天的00:00:00
     *
     * @param date
     * @return
     * @author lichengwu
     * @created Sep 13, 2011
     */
    public static Date toFirstSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定日期当天的最后一秒
     *
     * @param str
     * @return
     * @author lichengwu
     * @created Sep 13, 2011
     */
    public static Date toLastSecond(String str) {
        Date date = string2DateDay4Exception(str);
        return toLastSecond(date);
    }

    /**
     * 指定日期当天的00:00:00
     *
     * @param str
     * @return
     * @author lichengwu
     * @created Sep 13, 2011
     */
    public static Date toFirstSecond(String str) {
        Date date = string2DateDay4Exception(str);
        return toFirstSecond(date);
    }

    /*
     * 传入的是1~7,代表星期一至星期日
     * Calendar 周日是1 周一是2
    * */
    public static List<Date> filterByWeek(Date start, Date end, List<Integer> weeks) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("start or end is not null");
        }
        List<Date> dates = new ArrayList();
        if (end.getTime() <= start.getTime()) {
            return dates;
        }

        //trans weeks to real west week
        weeks = weeks.stream().filter(w -> w != null && w >= 1 && w <= 7).map(w -> w == 7 ? Calendar.SUNDAY : w + 1)
                .collect(Collectors.toList());
        while(!DateUtils.isSameDay(start, end)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(start);
            if (!weeks.contains(calendar.get(Calendar.DAY_OF_WEEK))) {
                dates.add(start);
            }
            start = DateUtil.addDays(start, 1);
        }
        return dates;
    }

    public static List<Date> filterByUnavailableDates(List<Date> dates, List<Date> unavailables) {
        if (CollectionUtils.isEmpty(unavailables)) return dates;
        List<Date> afterFilterDates = new ArrayList();
        for (Date date : dates) {
            boolean isFilter = Boolean.FALSE;
            for (Date unavailable : unavailables) {
                if (DateUtils.isSameDay(unavailable, date)) {
                    isFilter = true;
                    break;
                }
            }
            if (!isFilter) {
                afterFilterDates.add(date);
            }
        }
        return afterFilterDates;
    }

    public static String getGMT(Date date) {
        FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateString = FORMAT.format(date);
        return dateString;
    }
}
