package common;

import Service.wx.GetWxResponse;
import common.FlightInfo.CabinsInfoVO;
import common.FlightInfo.FlightInfoVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.io.IOException;
import java.util.*;

public class AnalyzeResponse {
    public Map<FlightInfoVO, CabinsInfoVO> analyzeResponse(){

        /**
         *@Author:fy39919
         *@Description:对response进行JSON处理，获取所需要的值
         *@Date:Created in 16:45 2018/1/20
         **/
        GetWxResponse getWxResponse = new GetWxResponse();
        List<Object> list = new ArrayList<Object>();
        String hour = "";
        String FlightInfoSimpleList = null;
        List list1 = null;
        Map<FlightInfoVO, CabinsInfoVO> map = new IdentityHashMap<FlightInfoVO, CabinsInfoVO>();
        try {
            list = getWxResponse.getresponse();
            //获取HTTP请求返回值
            String response = list.get(0).toString();
            System.out.println(response);
            JSONObject json =  JSONObject.fromObject(response);



            for(int i = 0;i<list.size();i++){
                String response1 = list.get(i).toString();
                JSONObject json1 =  JSONObject.fromObject(response1);
                JSONArray flightinfoarr = json1.getJSONArray("FlightInfoSimpleList");
                for(int k=0;k<flightinfoarr.size();k++){
                    FlightInfoVO flightInfoVO =new FlightInfoVO();

                    JSONObject flightinforow = flightinfoarr.getJSONObject(k);
                    String originAirportCode = new String(flightinforow.get("originAirportCode").toString());
                    String arriveAirportCode = new String(flightinforow.get("arriveAirportCode").toString());

                    flightInfoVO.setArrcode(originAirportCode);
                    flightInfoVO.setDepcode(originAirportCode);

                    JSONArray cabins = json1.getJSONArray(String.valueOf(flightinforow));

                    for(int m = 0;m<cabins.size();m++){
                        JSONObject cabinrow = cabins.getJSONObject(m);
                        CabinsInfoVO cabinsInfoVO = new CabinsInfoVO();
                        cabinsInfoVO.setFpoid(new String((String) cabinrow.get(("Fpoid").toString())));


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
