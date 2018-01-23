package service.wx;

import data.ExcelData;
import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class TestWX {

    @DataProvider(name="testT")
    public Object[][] Numbers() throws BiffException, IOException {
        ExcelData e=new ExcelData("Tdata", "T");
        return e.getExcelData();
    }
    @Test(dataProvider="testT")
    public void testAdd(HashMap<String, String> data){
        System.out.println(data.toString());
        String  Departure=data.get("Departure");
        System.out.println("----------"+Departure+"-------------------");
        Assert.assertEquals("SHA", Departure);
    }
}

