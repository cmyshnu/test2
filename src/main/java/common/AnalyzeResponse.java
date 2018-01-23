package common;

import service.wx.GetWxResponse;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


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
        String FlightInfoSimpleList = null;
        Map<flightInfoVO, cabinsInfoVO> map = new IdentityHashMap<flightInfoVO, cabinsInfoVO>();
        try {
            list = getWxResponse.getresponse();
            //获取HTTP请求返回值
            String response = list.get(0).toString();
            System.out.println(response);
            JSONObject json =  JSONObject.fromObject(response);


                /* 舱位信息 */
            for(int i = 0;i<list.size();i++){
                String response1 = list.get(i).toString();
                JSONObject json1 =  JSONObject.fromObject(response1);
                JSONArray flightinfoarr = json1.getJSONArray("FlightInfoSimpleList");
                for(int k=0;k<flightinfoarr.size();k++){
                    //fligthinfo获取起抵机场,航司,航班号,起飞时间
                    flightInfoVO flightInfoVO =new flightInfoVO();

                    JSONObject flightinforow = flightinfoarr.getJSONObject(k);
                    String originAirportCode = new String(flightinforow.get("originAirportCode").toString());
                    String arriveAirportCode = new String(flightinforow.get("arriveAirportCode").toString());
                    String airCompanyCode = new String(flightinforow.get("airCompanyCode").toString());
                    String flightNo = new String(flightinforow.get("flightNo").toString());
                    String flyOffOnlyTime = new String(flightinforow.get("flyOffOnlyTime").toString());

                    flightInfoVO.setArrCode(arriveAirportCode);
                    flightInfoVO.setDepCode(originAirportCode);
                    flightInfoVO.setAirCompanyCode(airCompanyCode);
                    flightInfoVO.setFlightNo(flightNo);
                    flightInfoVO.setFlightOffTime(flyOffOnlyTime);

                    JSONArray cabins = json1.getJSONArray(String.valueOf(flightinforow));

                    for(int m = 0;m<cabins.size();m++){

                        //cabins获取舱位,分众ID,供应商ID,政策ID,产品类型
                        JSONObject cabinrow = cabins.getJSONObject(m);
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
