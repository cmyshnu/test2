package exceldata;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class GetAirLineExcelDate {

/**
    *@Author:fy39919
    *@Description:获取excel数据
    *@Date:Created in 13:55 2018/1/20
 **/
    public Map<String ,String > getAirLine(String filepath){
        Map<String, String> map = new IdentityHashMap<String, String>();

        List<String> list = new ArrayList<String>();
        jxl.Workbook readwb = null;
        try{
            InputStream inputStream = new FileInputStream(filepath);

            readwb = Workbook.getWorkbook(inputStream);

            Sheet sheet = readwb.getSheet(0);

            //获取行数
            int rsRows = sheet.getRows();

            for(int i = 1; i < rsRows; i++){
                Cell cell1 = sheet.getCell(0,i);
                Cell cell2 = sheet.getCell(1,i);
                String getCell1 = new String(cell1.getContents().toString());
                String getCell2 = new String(cell2.getContents().toString());
                map.put(getCell1,getCell2);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }


        return map;
    }


}
