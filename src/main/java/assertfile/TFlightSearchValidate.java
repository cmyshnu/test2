package assertfile;

import JavaBean.TouchFlightSearch;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import data.DataProviderSet;
import data.ExcelData;
import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.wx.GetTFlightSearchResponse;

import java.io.IOException;
import java.util.HashMap;

public class TFlightSearchValidate{
     GetTFlightSearchResponse  getTFlightSearchResponse;
      String TFlightSearchResponseStr ;
/*    @Test(dataProvider="testTFlightSearch",dataProviderClass = DataProviderSet.class)
    public static  void TouchValidate(HashMap<String, String> data)throws Exception
    {
        GetTFlightSearchResponse getTFlightSearchResponse = new GetTFlightSearchResponse();
        TFlightSearchResponseStr=getTFlightSearchResponse.getResponse(data);
        System.out.println("****************************" + TFlightSearchResponseStr + "****************************");
    }*/

    /*@Test
    public   void  ValidateBaseInfo()
    {
       // JSONObject responseObject = JSON.parseObject(TFlightSearchResponseStr);

        TouchFlightSearch touchFlightSearch = JSON.parseObject(TFlightSearchResponseStr, TouchFlightSearch.class);
        System.out.println("========================"+touchFlightSearch.getFlyOffCode()+"======================");
        System.out.println("========================"+touchFlightSearch.getArriveCityCode()+"======================");
      //  String flyOffCityCode =responseObject.getString("FlyOffCityCode").toString();
       // System.out.println("FlyOffCity****************************"+flyOffCityCode+"****************************FlyOffCity");
       Assert.assertEquals("SHA", touchFlightSearch.getFlyOffCode());
       Assert.assertEquals("CTU", touchFlightSearch.getArriveCityCode());
        Assert.assertEquals("成都", touchFlightSearch.getArriveCity());
        Assert.assertEquals("上海", touchFlightSearch.getFlyOffCity());
        Assert.assertEquals(8, touchFlightSearch.getCompanyList().size());
        Assert.assertEquals("成都双流机场", touchFlightSearch.getFlightInfoSimpleList().get(0).getArriveAirportShortName());
        Assert.assertEquals("上海浦东机场", touchFlightSearch.getFlightInfoSimpleList().get(0).getOriginAirportShortName());
    }*/
    @Test(dataProvider="testTFlightSearch",dataProviderClass = DataProviderSet.class)
    public   void  ValidateBaseInfo(HashMap<String, String> data)throws Exception
    {
        // JSONObject responseObject = JSON.parseObject(TFlightSearchResponseStr);
        System.out.println("请求参数：--->>>"+data);
        GetTFlightSearchResponse getTFlightSearchResponse = new GetTFlightSearchResponse();
        TFlightSearchResponseStr=getTFlightSearchResponse.getResponse(data);
        getTFlightSearchResponse = new GetTFlightSearchResponse();
        TouchFlightSearch touchFlightSearch = JSON.parseObject(TFlightSearchResponseStr, TouchFlightSearch.class);
        System.out.println("验证起飞机场：--->>>"+touchFlightSearch.getFlyOffCode());
        System.out.println("验证抵达机场：--->>>"+touchFlightSearch.getArriveCityCode());
        //  String flyOffCityCode =responseObject.getString("FlyOffCityCode").toString();
        // System.out.println("FlyOffCity****************************"+flyOffCityCode+"****************************FlyOffCity");
        Assert.assertEquals("SHA", touchFlightSearch.getFlyOffCode());
        //Assert.assertEquals("CTU", touchFlightSearch.getArriveCityCode());
       // Assert.assertEquals("成都", touchFlightSearch.getArriveCity());
        Assert.assertEquals("上海", touchFlightSearch.getFlyOffCity());
       // Assert.assertEquals(8, touchFlightSearch.getCompanyList().size());
       // Assert.assertEquals("成都双流机场", touchFlightSearch.getFlightInfoSimpleList().get(0).getArriveAirportShortName());
       // Assert.assertEquals("上海浦东机场", touchFlightSearch.getFlightInfoSimpleList().get(0).getOriginAirportShortName());
    }








  /*  @Test
    public   void  Validate()
    {
        System.out.println("****************************"+TFlightSearchResponseStr+"****************************");
    }
  @Test
  public void  FlyOffCityCodevalidate()
    {
        JSONObject responseObject = JSON.parseObject(TFlightSearchResponseStr);
        String FlyOffCityCode =responseObject.getString("FlyOffCityCode");
        System.out.println("FlyOffCity****************************"+FlyOffCityCode+"****************************FlyOffCity");
        Assert.assertEquals("SHA", FlyOffCityCode);
    }

//公共的请求参数设置
  /*  @DataProvider(name="testTFlightSearch")
    public Object[][] Numbers() throws BiffException, IOException {
        ExcelData e=new ExcelData("TFlightSearchData", "TFlightSearch");
        return e.getExcelData();
    }*/
    /*@Test(dataProvider="testTFlightSearch",dataProviderClass = DataProviderSet.class)
    public void testTouchFlightSearch(HashMap<String, String> data) throws IOException {
        System.out.println(data.toString());
    //    String  respionse=TFlightSearchResponse.getResponse(data);

        String  Departure=data.get("Departure");
        Assert.assertEquals("SHA", Departure);
    }*/

/*
    @Test
    public void testTouchFlightSearch() throws IOException {
        System.out.println(data.toString());
        String  respionse=TFlightSearchResponse.getResponse(data);
        String  Departure=data.get("Departure");
        Assert.assertEquals("SHA", Departure);
    }

*/


}
