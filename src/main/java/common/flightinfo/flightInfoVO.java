package common.flightinfo;

public class flightInfoVO {

    //起飞机场
    private String depCode;

    //抵达机场
    private String arrCode;

    //起飞时间
    private String flightOffTime;

    //航司
    private String airCompanyCode;

    //航班号
    private String flightNo;


    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getArrCode() {
        return arrCode;
    }

    public void setArrCode(String arrCode) {
        this.arrCode = arrCode;
    }

    public String getFlightOffTime() {
        return flightOffTime;
    }

    public void setFlightOffTime(String flightOffTime) {
        this.flightOffTime = flightOffTime;
    }

    public String getAirCompanyCode() {
        return airCompanyCode;
    }

    public void setAirCompanyCode(String airCompanyCode) {
        this.airCompanyCode = airCompanyCode;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getCabinInfo() {
        return cabinInfo;
    }

    public void setCabinInfo(String cabinInfo) {
        this.cabinInfo = cabinInfo;
    }

    private String cabinInfo;

}
