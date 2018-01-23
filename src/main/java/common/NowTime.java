package common;

import java.util.Calendar;

public class NowTime {
    public String nowTime(){
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        // 取当前日期的后一天
        return format.format(cal.getTime());
    }
}
