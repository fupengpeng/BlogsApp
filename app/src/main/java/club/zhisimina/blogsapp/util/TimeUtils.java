package club.zhisimina.blogsapp.util;

import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 获取当前的系統時間
 */
public class TimeUtils {

    public static final int INT = 22;
    public static final int INT1 = 23;

    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR) + "";
        String month = (calendar.get(Calendar.MONTH) + 1) + "";
        int m = Integer.parseInt(month);
        if (m >= 0 && m < 10) {
            month = "0" + month;
        }
        String date = calendar.get(Calendar.DATE) + "";
        int d = Integer.parseInt(date);
        if (d >= 0 && d < 10) {
            date = "0" + date;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(month);
        buffer.append(date);
        buffer.append(year);
        return buffer.toString();
    }

    public static String getTime1() {
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR) + "";
        String month = (calendar.get(Calendar.MONTH) + 1) + "";
        int m = Integer.parseInt(month);
        if (m >= 0 && m < 10) {
            month = "0" + month;
        }
        String date = calendar.get(Calendar.DATE) + "";
        int d = Integer.parseInt(date);
        if (d >= 0 && d < 10) {
            date = "0" + date;
        }
        String hour = calendar.get(Calendar.HOUR) + "";
        int h = Integer.parseInt(hour);
        if (h >= 0 && h < 10) {
            hour = "0" + hour;
        }
        String minute = calendar.get(Calendar.MINUTE) + "";
        int mi = Integer.parseInt(minute);
        if (mi >= 0 && mi < 10) {
            minute = "0" + minute;
        }
        String second = calendar.get(Calendar.SECOND) + "";
        int s = Integer.parseInt(second);
        if (s > 0 && s < 10) {
            second = "0" + second;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(year);
        buffer.append(month);
        buffer.append(date);
        buffer.append(hour);
        buffer.append(minute);
        buffer.append(second);
        return buffer.toString();
    }


    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDate(int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LogUtils.e("前7天==" + dft.format(endDate));
        return dft.format(endDate);
    }


    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateTimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 倒计时
     *
     * @param min 倒计时间（分钟）
     */
    public void CountDown(int min) {

        //开始时间
        long start = System.currentTimeMillis();
        //结束时间
        final long end = start + min * 60 * 1000;

        final Timer timer = new Timer();
        //延迟0毫秒（即立即执行）开始，每隔1000毫秒执行一次
        timer.schedule(new TimerTask() {
            public void run() {
                Log.e("MainActivity", "此处实现倒计时，指定时长内，每隔1秒执行一次该任务");
            }
        }, 0, 1000);
        //计时结束时候，停止全部timer计时计划任务
        timer.schedule(new TimerTask() {
            public void run() {
                timer.cancel();
            }

        }, new Date(end));
    }

    public static int time = 60 * 60 * 60;
    public static Calendar c;
    public static long endTime;
    public static Date date;
    public static long startTime;
    public static long midTime;

    /**
     * 方式二： 设定时间戳，倒计时
     */
    private static void time2() {

        c = Calendar.getInstance();
        c.set(2017, 4, 17, 0, 0, 0);// 注意月份的设置，0-11表示1-12月
        // c.set(Calendar.MONTH, 4);
        // c.set(Calendar.DAY_OF_MONTH, 17);
        // c.set(Calendar.HOUR_OF_DAY, 0);
        // c.set(Calendar.MINUTE, 0);
        // c.set(Calendar.SECOND, 0);
        endTime = c.getTimeInMillis();
        date = new Date();
        startTime = date.getTime();
        midTime = (endTime - startTime) / 1000;

        while (midTime > 0) {
            midTime--;
            long hh = midTime / 60 / 60 % 60;
            long mm = midTime / 60 % 60;
            long ss = midTime % 60;
            System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void daojishi(Long midTime , TextView textView) {

        while (midTime > 0) {
            midTime--;
            long hh = midTime / 60 / 60 % 60;
            long mm = midTime / 60 % 60;
            long ss = midTime % 60;
            textView.setText( hh + "小时" + mm + "分钟" + ss + "秒");
            LogUtils.e("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
