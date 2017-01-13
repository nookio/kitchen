package form.house;

import form.BaseForm;

import javax.persistence.Column;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/14 上午11:49
 * @Descrition:
 */
public class HouseFacilityForm extends BaseForm{

    private Integer houseId;

    private Long shopSignSizeOne; //店招1

    private Long shopSignSizeTwo;  //店招2

    private Integer power; //是否有动力电

    private String capacitance; //电容量

    private Integer capacityIncrease; //可以增容

    private Integer upPipe; //上水管

    private Integer downPipe; //下水管

    private String downPipeDiameter; //下水管直径

    private Integer gas; //下水管直径

    private Integer gasCylinders; //煤气罐

    private Integer fire; //煤气罐

    private Integer duct; //排烟道

    private Long ductRate; //排风量

    private Integer blowOff; //排污管道

    private Integer greaseTrap; //隔油池

    private Integer oilFume; //油烟过滤器

    private Integer selfCarPortSize; //自由停车位

    private Integer aroundCarPortSize; //周边停车位

    private Integer outWard; //是否有外摆区


    public Long getShopSignSizeOne() {
        return shopSignSizeOne;
    }

    public void setShopSignSizeOne(Long shopSignSizeOne) {
        this.shopSignSizeOne = shopSignSizeOne;
    }

    public Long getShopSignSizeTwo() {
        return shopSignSizeTwo;
    }

    public void setShopSignSizeTwo(Long shopSignSizeTwo) {
        this.shopSignSizeTwo = shopSignSizeTwo;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getCapacityIncrease() {
        return capacityIncrease;
    }

    public void setCapacityIncrease(Integer capacityIncrease) {
        this.capacityIncrease = capacityIncrease;
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

    public String getCapacitance() {
        return capacitance;
    }

    public void setCapacitance(String capacitance) {
        this.capacitance = capacitance;
    }

    public String getDownPipeDiameter() {
        return downPipeDiameter;
    }

    public void setDownPipeDiameter(String downPipeDiameter) {
        this.downPipeDiameter = downPipeDiameter;
    }

    public Integer getGas() {
        return gas;
    }

    public void setGas(Integer gas) {
        this.gas = gas;
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

    public Long getDuctRate() {
        return ductRate;
    }

    public void setDuctRate(Long ductRate) {
        this.ductRate = ductRate;
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

    public Integer getSelfCarPortSize() {
        return selfCarPortSize;
    }

    public void setSelfCarPortSize(Integer selfCarPortSize) {
        this.selfCarPortSize = selfCarPortSize;
    }

    public Integer getAroundCarPortSize() {
        return aroundCarPortSize;
    }

    public void setAroundCarPortSize(Integer aroundCarPortSize) {
        this.aroundCarPortSize = aroundCarPortSize;
    }

    public Integer getOutWard() {
        return outWard;
    }

    public void setOutWard(Integer outWard) {
        this.outWard = outWard;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
