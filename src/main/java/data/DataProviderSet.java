package data;

import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public  class DataProviderSet {
    @DataProvider(name="testTFlightSearch")
    public  static   Object[][] Numbers() throws BiffException, IOException {
        ExcelData e=new ExcelData("TFlightSearchData", "TFlightSearch");
        return e.getExcelData();
    }
}
