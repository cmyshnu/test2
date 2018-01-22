package common.FlightInfo;

public class FlightInfoVO {
    private String depcode;
    private String arrcode;
    private String flightofftime;
    private String airCompanyCode;
    private String flightNo;
    private String cabinsinfoVO;

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String getArrcode() {
        return arrcode;
    }

    public void setArrcode(String arrcode) {
        this.arrcode = arrcode;
    }

    public String getFlightofftime() {
        return flightofftime;
    }

    public void setFlightofftime(String flightofftime) {
        this.flightofftime = flightofftime;
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

    public String getCabinsinfoVO() {
        return cabinsinfoVO;
    }

    public void setCabinsinfoVO(String cabinsinfoVO) {
        this.cabinsinfoVO = cabinsinfoVO;
    }
}
