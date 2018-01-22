package common;

import java.util.Calendar;

public class DepDate {
    public String getDate(){
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, +2);// 取当前日期的后一天.
        String depdate = format.format(cal.getTime());
        return depdate;
    }
}
