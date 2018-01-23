package common;

/**
 * 起抵机场
 * @author fy39919
 */
public class CityVO {
    private String depCode;
    private String arrCode;

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

    @Override
    public String toString(){
        return super.toString()+"{depCode"+depCode+"arrCode+"+arrCode+"}";
    }
}
