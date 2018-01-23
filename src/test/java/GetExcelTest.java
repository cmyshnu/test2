import common.cityVO;
import data.AirlineExcelData;
import data.GetAirLineExcelDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetExcelTest {
    public static void main(String[] args) {
        AirlineExcelData airlineExcelData = new AirlineExcelData();
        List<cityVO> list = new ArrayList<cityVO>();
        list = airlineExcelData.airLineInfo("d:/airlines.xls");
        for (int i =0; i<list.size();i++){
            String arr = list.get(i).getArrCode();
            String dep = list.get(i).getDepCode();
            System.out.println(dep+"  "+arr);
        }

    }
}