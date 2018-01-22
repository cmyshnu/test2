import common.AnalyzeResponse;

import java.util.Map;

public class Anatest {
    public static void main(String[] args) {
        AnalyzeResponse analyzeResponse = new AnalyzeResponse();
        Map<String,String> a = analyzeResponse.analyzeResponse();
        for(Map.Entry<String, String> entry : a.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
//        List a = analyzeResponse.analyzeResponse();
//        for(int i = 0;i<a.size();i++){
//            System.out.println(a.get(i));
//        }
    }
}
