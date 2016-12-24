package models;


import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meiyuan.com
 * @Date: 16/12/6 上午10:48
 * @Descrition: TODO
 */
@Entity
public class Facility extends Base {

    public final static Finder<Integer, Facility> finder = new Finder<Integer, Facility>(Facility.class);

    @Column
    private Integer houseId;

//    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
//    public House houseShow;

    @Column
    private Long shopSignSizeOne; //店招1

    @Column
    private Long shopSignSizeTwo;  //店招2

    @Column
    private Integer power; //是否有动力电

    @Column
    private Integer capacitance; //电容量

    @Column
    private Integer capacityIncrease; //可以增容

    @Column
    private Integer upPipe; //上水管

    @Column
    private Integer downPipe; //下水管

    @Column
    private Integer downPipeDiameter; //下水管直径

    @Column
    private Integer gas; //下水管直径

    @Column
    private Integer gasCylinders; //煤气罐

    @Column
    private Integer fire; //煤气罐

    @Column
    private Integer duct; //排烟道

    @Column
    private Long ductRate; //排风量

    @Column
    private Integer blowOff; //排污管道

    @Column
    private Integer greaseTrap; //隔油池

    @Column
    private Integer oilFume; //油烟过滤器

    @Column
    private Integer selfCarPortSize; //自由停车位

    @Column
    private Integer aroundCarPortSize; //周边停车位

    @Column
    private Integer outWard; //是否有外摆区


    @Column
    private Integer status;

    @Column
    @UpdatedTimestamp
    private Date updated_date;

    @Column
    @CreatedTimestamp
    private Date created_date;

    public Facility() {
    }

    public Facility(Integer houseId) {
        this.houseId = houseId;
        this.shopSignSizeOne = 0l;
        this.shopSignSizeTwo = 0l;
        this.power = 1;
        this.capacitance = 0;
        this.capacityIncrease = 0;
        this.upPipe = 1;
        this.downPipe = 1;
        this.downPipeDiameter = 0;
        this.gas = 1;
        this.gasCylinders = 0;
        this.fire = 1;
        this.duct = 1;
        this.ductRate = 0l;
        this.blowOff = 1;
        this.greaseTrap = 0;
        this.oilFume = 1;
        this.selfCarPortSize = 0;
        this.aroundCarPortSize = 0;
        this.outWard = 0;
        this.status = INIT;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

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

    public Integer getCapacitance() {
        return capacitance;
    }

    public void setCapacitance(Integer capacitance) {
        this.capacitance = capacitance;
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

    public Integer getDownPipeDiameter() {
        return downPipeDiameter;
    }

    public void setDownPipeDiameter(Integer downPipeDiameter) {
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

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

//    public House getHouse() {
//        return houseShow;
//    }
//
//    public void setHouse(House houseShow) {
//        this.houseShow = houseShow;
//    }
}
