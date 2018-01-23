package assertfile;

import common.AnalyzeResponse;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.wx.GetWxResponse;

import java.io.IOException;
import java.util.*;

public class Assert {

    @Test
    public void testWxFlightOffTime(){
        AnalyzeResponse analyzeResponse = new AnalyzeResponse();
        List<String> list = new ArrayList<String>();
        Map<flightInfoVO, cabinsInfoVO> map = analyzeResponse.analyzeResponse();
        for(Map.Entry<flightInfoVO,cabinsInfoVO> entry : map.entrySet()){
            list.add(entry.getKey().getFlightOffTime());
        }
        Collections.sort(list);
        String time = list.get(0);
        System.out.println(time);


    }


}
