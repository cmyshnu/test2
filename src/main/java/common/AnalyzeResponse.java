package common;

<<<<<<< HEAD
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import service.wx.GetWxResponse;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;
=======
import org.json.JSONArray;
import service.wx.GetWxResponse;
import common.flightinfo.cabinsInfoVO;
import common.flightinfo.flightInfoVO;
import org.json.JSONObject;
>>>>>>> 456a71aa4d0f49040be09c4b9ad06afb662671fc


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
        Map<flightInfoVO, cabinsInfoVO> map = new IdentityHashMap<flightInfoVO, cabinsInfoVO>();

        try {
            //获取http返回值
            list = getWxResponse.getresponse();
<<<<<<< HEAD
            //获取HTTP请求返回值
            String response = list.get(0).toString();
            System.out.println(response);
            //              // 利用阿狸的json包  JSONObject json =  JSONObject.fromObject(response);
            JSONObject json =  JSONObject.parseObject(response);
                /* 舱位信息 */
            for(int i = 0;i<list.size();i++){
                String response1 = list.get(i).toString();
                // 利用阿狸的json包      JSONObject json1 =  JSONObject.fromObject();
                JSONObject json1 =  JSONObject.parseObject(response1);

                JSONArray flightinfoarr = json1.getJSONArray("FlightInfoSimpleList");
                for(int k=0;k<flightinfoarr.size();k++){
                    //fligthinfo获取起抵机场,航司,航班号,起飞时间
                    flightInfoVO flightInfoVO =new flightInfoVO();
=======

                /* 舱位信息 */
            for(int i = 0;i<list.size();i++){
>>>>>>> 456a71aa4d0f49040be09c4b9ad06afb662671fc

                String response = list.get(i).toString();
                JSONObject flightJson = new JSONObject(response);
                JSONArray flightInfoArr = flightJson.getJSONArray("FlightInfoSimpleList");

                for(int k=0;k<flightInfoArr.length();k++){


                    /**
                     *flgths获取起抵机场,航司,航班号,起飞时间
                     * fy39919
                     **/


                    flightInfoVO flightInfoVO =new flightInfoVO();
                    JSONObject flightinforow = flightInfoArr.getJSONObject(k);
                    String originAirportCode = new String(flightinforow.get("originAirportCode").toString());
                    String arriveAirportCode = new String(flightinforow.get("arriveAirportCode").toString());
                    String airCompanyCode = new String(flightinforow.get("airCompanyCode").toString());
                    String flightNo = new String(flightinforow.get("flightNo").toString());
                    String flyOffOnlyTime = new String(flightinforow.get("flyOffOnlyTime").toString());
//                    System.out.println(originAirportCode+" "+arriveAirportCode);

                    //航班信息flightInfoVO
                    flightInfoVO.setArrCode(arriveAirportCode);
                    flightInfoVO.setDepCode(originAirportCode);
                    flightInfoVO.setAirCompanyCode(airCompanyCode);
                    flightInfoVO.setFlightNo(flightNo);
                    flightInfoVO.setFlightOffTime(flyOffOnlyTime);

                    //flightInfo信息拿cabins
                    JSONObject cabinsJson = new JSONObject(flightInfoArr.get(i).toString());
                    JSONArray cabinsArr = cabinsJson.getJSONArray("cabins");
                    for(int m = 0;m<cabinsArr.length();m++){

                        /**
                         * cabins获取舱位,分众ID,供应商ID,政策ID,产品类型
                         * fy39919
                         **/
                        JSONObject cabinInfoJson = cabinsArr.getJSONObject(m);
                        cabinsInfoVO cabinsInfoVO = new cabinsInfoVO();

                        String realRoomCode = new String(cabinInfoJson.get("realRoomCode").toString());
                        String fProductCode = new String(cabinInfoJson.get("fProductCode").toString());
                        String mid = new String(cabinInfoJson.get("mid").toString());
                        String fpoid = new String(cabinInfoJson.get("fpoid").toString());
                        String fat = new String(cabinInfoJson.get("fat").toString());

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
