package common;

import org.json.JSONArray;
import service.wx.GetWxResponse;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;
import org.json.JSONObject;


import java.io.IOException;
import java.util.*;


/**
 * 解析JSON
 * @author fy39919
 */
public class AnalyzeResponse {
    public Map<flightInfoVO, cabinsInfoVO> analyzeResponse(){

        GetWxResponse getWxResponse = new GetWxResponse();
        List<Object> list = new ArrayList<Object>();

        //航班信息
        String flightInfoSimpleList = null;
        Map<flightInfoVO, cabinsInfoVO> map = new IdentityHashMap<flightInfoVO, cabinsInfoVO>();
        try {
            list = getWxResponse.getresponse();

                /* 舱位信息 */
            for(int i = 0;i<list.size();i++){
                String response = list.get(i).toString();
                JSONObject flightJson = new JSONObject(response);

                JSONArray flightInfoArr = flightJson.getJSONArray("FlightInfoSimpleList");

                for(int k=0;k<flightInfoArr.length();k++){

                    //flgths获取起抵机场,航司,航班号,起飞时间
                    flightInfoVO flightInfoVO =new flightInfoVO();
                    JSONObject flightinforow = flightInfoArr.getJSONObject(k);
                    String originAirportCode = new String(flightinforow.get("originAirportCode").toString());
                    String arriveAirportCode = new String(flightinforow.get("arriveAirportCode").toString());
                    String airCompanyCode = new String(flightinforow.get("airCompanyCode").toString());
                    String flightNo = new String(flightinforow.get("flightNo").toString());
                    String flyOffOnlyTime = new String(flightinforow.get("flyOffOnlyTime").toString());
                    System.out.println(originAirportCode+" "+arriveAirportCode);
                    flightInfoVO.setArrCode(arriveAirportCode);
                    flightInfoVO.setDepCode(originAirportCode);
                    flightInfoVO.setAirCompanyCode(airCompanyCode);
                    flightInfoVO.setFlightNo(flightNo);
                    flightInfoVO.setFlightOffTime(flyOffOnlyTime);

                    String cabins = flightinforow.get("cabins").toString();

                    System.out.println(cabins);
                    JSONObject cabinsJson = new JSONObject(flightinforow.get("cabins").toString());
                    JSONArray cabinsArr = cabinsJson.getJSONArray("cabins");

                    for(int m = 0;m<cabinsArr.length();m++){

                        //cabins获取舱位,分众ID,供应商ID,政策ID,产品类型
                        JSONObject cabinrow = cabinsArr.getJSONObject(m);

                        cabinsInfoVO cabinsInfoVO = new cabinsInfoVO();

                        String realRoomCode = new String(cabinrow.get("realRoomCode").toString());
                        String fProductCode = new String(cabinrow.get("fProductCode").toString());
                        String mid = new String(cabinrow.get("mid").toString());
                        String fpoid = new String(cabinrow.get("fpoid").toString());
                        String fat = new String(cabinrow.get("fat").toString());

                        cabinsInfoVO.setRealRoomCode(realRoomCode);
                        cabinsInfoVO.setMid(mid);
                        cabinsInfoVO.setfProductCode(fProductCode);
                        cabinsInfoVO.setfPoid(fpoid);
                        cabinsInfoVO.setFat(fat);

                        map.put(flightInfoVO,cabinsInfoVO);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  map;
    }

}
