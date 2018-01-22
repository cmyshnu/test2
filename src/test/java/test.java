import service.wx.GetWxResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        GetWxResponse getWxResponse = new GetWxResponse();
        List<Object> list = new ArrayList<Object>();
        try {
            list = getWxResponse.getresponse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0));
    }
}
