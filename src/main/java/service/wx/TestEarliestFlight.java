package service.wx;

import common.AnalyzeResponse;
import common.NowTime;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.wx.GetWxResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestEarliestFlight {

    @Test
    public void testWxFlightOffTime() throws ParseException {
        NowTime nowTime = new NowTime();
        String time1 = nowTime.nowTime();
        System.out.println(time1);
        AnalyzeResponse analyzeResponse = new AnalyzeResponse();
        List<String> list = new ArrayList<String>();
        Map<flightInfoVO, cabinsInfoVO> map = analyzeResponse.analyzeResponse();
        for(Map.Entry<flightInfoVO,cabinsInfoVO> entry : map.entrySet()){
            list.add(entry.getKey().getFlightOffTime());
        }
        Collections.sort(list);


        String time = list.get(0).toString();
        System.out.println(time);
        DateFormat df = new SimpleDateFormat("HH:mm");
        Date dt1 = df.parse(time);
        Date dt2 = df.parse(time1);

        assert dt1.getTime()<dt2.getTime();

    }
}
