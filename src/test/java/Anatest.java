import common.AnalyzeResponse;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;

import java.util.Map;

public class Anatest {
    public static void main(String[] args) {
        AnalyzeResponse analyzeResponse = new AnalyzeResponse();
        Map<flightInfoVO, cabinsInfoVO> map= analyzeResponse.analyzeResponse();
        for(Map.Entry<flightInfoVO, cabinsInfoVO> entry: map.entrySet()){
            System.out.println(entry.getKey().getFlightOffTime()+entry.getKey().getAirCompanyCode());

        }

//        List a = analyzeResponse.analyzeResponse();
//        for(int i = 0;i<a.size();i++){
//            System.out.println(a.get(i));
//        }
    }
}
