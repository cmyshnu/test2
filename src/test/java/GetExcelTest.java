import data.GetAirLineExcelDate;

import java.util.HashMap;
import java.util.Map;

public class GetExcelTest {
    public static void main(String[] args) {

        GetAirLineExcelDate getAirLineExcelDate = new GetAirLineExcelDate();

        Map<String,String> map = new HashMap<String,String>();

        map = getAirLineExcelDate.getAirLine("d:/airlines.xls");
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }