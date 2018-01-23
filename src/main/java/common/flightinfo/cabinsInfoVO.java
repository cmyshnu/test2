package common.flightinfo;

/**
 * @author fy39919
 */
public class cabinsInfoVO {
    /**
   * 政策ID
   *
   **/
    private String fPoid;
    /**
     * 供应商ID
     *
     **/
    private String mid;
    /**
     * 分众规则
     *
     **/
    private String fProductCode;
    /**
     * 类型
     *
     **/
    private String fat;
    /**
     * 舱位
     *
     **/
    private String realRoomCode;

    public String getfPoid() {
        return fPoid;
    }

    public void setfPoid(String fPoid) {
        this.fPoid = fPoid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getfProductCode() {
        return fProductCode;
    }

    public void setfProductCode(String fProductCode) {
        this.fProductCode = fProductCode;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getRealRoomCode() {
        return realRoomCode;
    }

    public void setRealRoomCode(String realRoomCode) {
        this.realRoomCode = realRoomCode;
    }

    @Override
    public String toString(){
        return super.toString()+"{+fPoid"+fPoid+"mid"+mid+"fProductCode"+fProductCode+"fat"+fat+"realRoomCode"+realRoomCode+"}";
    }

}
