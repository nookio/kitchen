package form.house;

import form.BaseForm;
import form.BasePageForm;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/14 上午10:36
 * @Descrition:
 */
public class HouseQueryForm extends BasePageForm {

    private Integer acreagenS;//面积范围开始

    private Integer acreagenE;//面积范围结束

    private Long chummageDailyS; //日租金开始

    private Long chummageDailyE; //日租金结束

    private Long personAverageS; //人均消费开始

    private Long personAverageE; //人均消费结束

    private Integer districtCode; //区域

    private List<Integer> houseType; //房间类型

    private List<Integer> houseLevel; //房间等级

    private List<Integer> houseSource; //商铺来源

    private Integer power; //是否有动力电

    private Integer upPipe; //上水管

    private Integer downPipe; //下水管

    private Integer gasCylinders; //煤气罐


    private Integer gas; //天然气

    private Integer fire; //明火

    private Integer duct; //排烟道

    private Integer blowOff; //排污管道

    private Integer greaseTrap; //隔油池

    private Integer oilFume; //油烟过滤器

    private List<Integer> signs; //标志建筑物

    private List<Integer> businessStatus; //经营业态

    private List<Integer> rentStatus; //出租状态

    private Integer orderBy;

    public Integer getAcreagenS() {
        return acreagenS;
    }

    public void setAcreagenS(Integer acreagenS) {
        this.acreagenS = acreagenS;
    }

    public Integer getAcreagenE() {
        return acreagenE;
    }

    public void setAcreagenE(Integer acreagenE) {
        this.acreagenE = acreagenE;
    }

    public Long getChummageDailyS() {
        return chummageDailyS;
    }

    public void setChummageDailyS(Long chummageDailyS) {
        this.chummageDailyS = chummageDailyS;
    }

    public Long getChummageDailyE() {
        return chummageDailyE;
    }

    public void setChummageDailyE(Long chummageDailyE) {
        this.chummageDailyE = chummageDailyE;
    }

    public Long getPersonAverageS() {
        return personAverageS;
    }

    public void setPersonAverageS(Long personAverageS) {
        this.personAverageS = personAverageS;
    }

    public Long getPersonAverageE() {
        return personAverageE;
    }

    public void setPersonAverageE(Long personAverageE) {
        this.personAverageE = personAverageE;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public List<Integer> getHouseType() {
        return houseType;
    }

    public void setHouseType(List<Integer> houseType) {
        this.houseType = houseType;
    }

    public List<Integer> getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(List<Integer> houseLevel) {
        this.houseLevel = houseLevel;
    }

    public List<Integer> getHouseSource() {
        return houseSource;
    }

    public void setHouseSource(List<Integer> houseSource) {
        this.houseSource = houseSource;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getUpPipe() {
        return upPipe;
    }

    public void setUpPipe(Integer upPipe) {
        this.upPipe = upPipe;
    }

    public Integer getDownPipe() {
        return downPipe;
    }

    public void setDownPipe(Integer downPipe) {
        this.downPipe = downPipe;
    }

    public Integer getGasCylinders() {
        return gasCylinders;
    }

    public void setGasCylinders(Integer gasCylinders) {
        this.gasCylinders = gasCylinders;
    }

    public Integer getFire() {
        return fire;
    }

    public void setFire(Integer fire) {
        this.fire = fire;
    }

    public Integer getDuct() {
        return duct;
    }

    public void setDuct(Integer duct) {
        this.duct = duct;
    }

    public Integer getBlowOff() {
        return blowOff;
    }

    public void setBlowOff(Integer blowOff) {
        this.blowOff = blowOff;
    }

    public Integer getGreaseTrap() {
        return greaseTrap;
    }

    public void setGreaseTrap(Integer greaseTrap) {
        this.greaseTrap = greaseTrap;
    }

    public Integer getOilFume() {
        return oilFume;
    }

    public void setOilFume(Integer oilFume) {
        this.oilFume = oilFume;
    }

    public List<Integer> getSigns() {
        return signs;
    }

    public void setSigns(List<Integer> signs) {
        this.signs = signs;
    }

    public List<Integer> getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(List<Integer> businessStatus) {
        this.businessStatus = businessStatus;
    }

    public List<Integer> getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(List<Integer> rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getGas() {
        return gas;
    }

    public void setGas(Integer gas) {
        this.gas = gas;
    }
}
