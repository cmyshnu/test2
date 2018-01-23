package data;

import common.cityVO;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AirlineExcelData {

    public List<cityVO> airLineInfo(String filepath){
        List<cityVO> list = new ArrayList<cityVO>();
        cityVO city =new cityVO();
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
                city.setArrCode(getCell2);
                city.setDepCode(getCell1);
                list.add(city);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }



        return list;
    }

}
