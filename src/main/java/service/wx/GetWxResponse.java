package service.wx;

import common.cityVO;
import data.AirlineExcelData;
import data.GetAirLineExcelDate;
import common.DepDate;
import common.HttpRequests;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取WX返回参数
 * @author fy39919
 */
public class GetWxResponse {
    public List<Object> getresponse() throws IOException {
        List<Object> list1 = new ArrayList<Object>();
        HttpRequests http = new HttpRequests();
        AirlineExcelData airlineExcelData = new AirlineExcelData();
        DepDate depDate = new DepDate();
        GetParam getParam = new GetParam();
        //从配置里获取接口地址
        GetUrl getUrl = new GetUrl();
        String url = getUrl.geturl("wx");
        String filepath = "d:/airlines.xls";

        List<cityVO> list ;
        list = airlineExcelData.airLineInfo(filepath);

        for (int i =0; i<list.size();i++){
            String arr = list.get(i).getArrCode();
            String dep = list.get(i).getDepCode();
            String param = getParam.getParam(arr,dep,depDate.getDate());
            list1.add(http.getRequests(url,param).toString());
        }


        return list1;
    }

}
