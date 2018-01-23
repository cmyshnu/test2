package service.wx;

import data.GetAirLineExcelDate;
import common.DepDate;
import common.HttpRequests;

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
        List<Object> list = new ArrayList<Object>();
        HttpRequests http = new HttpRequests();

        DepDate depDate = new DepDate();
        GetParam getParam = new GetParam();
        //从配置里获取接口地址
        GetUrl getUrl = new GetUrl();
        String url = getUrl.geturl("wx");

        GetAirLineExcelDate getAirLineExcelDate = new GetAirLineExcelDate();
        String filepath = "d:/airlines.xls";
        Map<String,String> map1;
        map1 = getAirLineExcelDate.getAirLine(filepath);

        for (Map.Entry<String,String> entry : map1.entrySet()){
            String param = getParam.getParam(entry.getKey(),entry.getValue(),depDate.getDate());
            list.add(http.getRequests(url,param).toString());
        }

        return list;
    }

}
