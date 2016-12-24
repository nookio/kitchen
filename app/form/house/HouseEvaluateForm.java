package form.house;

import form.BaseForm;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午6:06
 * @Descrition:
 */
public class HouseEvaluateForm extends BaseForm{
    private Integer houseId;

    private Integer marchatLevel; //评价登记

    private Integer houseLevel; //店铺评级

    private String good;

    private String bad;

    private String proposed;

    public Integer getMarchatLevel() {
        return marchatLevel;
    }

    public void setMarchatLevel(Integer marchatLevel) {
        this.marchatLevel = marchatLevel;
    }

    public Integer getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(Integer houseLevel) {
        this.houseLevel = houseLevel;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getBad() {
        return bad;
    }

    public void setBad(String bad) {
        this.bad = bad;
    }

    public String getProposed() {
        return proposed;
    }

    public void setProposed(String proposed) {
        this.proposed = proposed;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
