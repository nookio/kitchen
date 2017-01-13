package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import form.house.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meiyuan.com
 * @Date: 16/12/6 上午10:44
 * @Descrition: TODO
 */
@Entity
public class House extends Base {

    public final static Finder<Integer, House> finder = new Finder<Integer, House>(House.class);

    @Column
    private String code; //商铺编号

    /**
     *   租售信息
     */
    @Column
    private Integer rentBusinessType;  //出租业务类型

    @Column
    private Integer rentStatus;  //租售状态


    /**
     * 位置信息
     */
    //省
    @Column
    private Integer provinceCode;

    //市
    @Column
    private Integer cityCode;

    //县
    @Column
    private Integer areaCode;

    //区域
    @Column
    private Integer districtCode;

    //地址
    @Column
    @Size(max = 500)
    private String address;

    //经度
    @Column
    private String longitude;

    //纬度
    @Column
    private String latitude;

    //地图url
    @Column
    private String mapUrl;

    //地图类型
    @Column
    private String mapUrlType;

    //全景url
    @Column
    private String wholeMapUrl;

    @Column
    private String hotMapUrl; //热力地图

    /**
     * 当前状态
     */
    @Column
    private Integer operateStatus; //经营业态 营业中/无业

    @Column
    private String businessName; //经营品牌

    @Column
    private String businessStatus; //当前业态(米粉/面条)


    /**
     * 建筑信息
     */
    //商铺类型
    @Column
    private Integer houseType;

    //产权人类型
    @Column
    private Integer ownerType;

    //产权人
    @Column
    private String owner;

    @Column
    private Integer propertyRightType = 1;

    @Column
    private String floor; //第几层

    @Column
    private String maxFloor; //一共几层

    @Column
    private Long areas; //建筑面积

    @Column
    private Long buildAreas; //建筑面积

    @Column
    private Long useAreas; //建筑面积

    @Column
    private Long effien; //得房率

    @Column
    private Integer showLength; //展示面宽度


    @Column
    private Long height;

    @Column
    private Integer rentType; //0:不整租, 1:整租

    @Column
    private Long shade; //遮挡程度

    @Column
    private Integer decoration; //0无, 1有装修

    /**
     * 配套设施
     */
    @Column
    private Long shopSignSizeOne; //店招1

    @Column
    private Long shopSignSizeTwo;  //店招2

    @Column
    private Integer power; //是否有动力电

    @Column
    private String capacitance; //电容量

    @Column
    private Integer capacityIncrease; //可以增容

    @Column
    private Integer upPipe; //上水管

    @Column
    private Integer downPipe; //下水管

    @Column
    private String downPipeDiameter; //下水管直径

    @Column
    private Integer gas; //天然气

    @Column
    private Integer gasCylinders; //煤气罐

    @Column
    private Integer fire; //明火

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




    //经营状态
    @Column
    private String business; //经营业态

    /**
     * 费用相关
     */
    @Column
    private Long chummageDaily; //每天租金

    @Column
    private Long chummageMonth; //每月租金

    @Column
    private Long chummageYear; //每年租金

    @Column
    private Integer chummageIncrease; //租金递增

    @Column
    private String chummageIncreaseRule; //租金递增规则

    @Column
    private Long transferCost; //转让费

    @Column
    private String pledgeMonth; //压几个月

    @Column
    private String payMonth; //附几个月

    @Column
    private Long propertyFee; //物业费

    @Column
    private Long waterFee; //水费

    @Column
    private Long gasFee; //天然气费

    @Column
    private Long elasFee; //电费

    @Column
    private Long shopSignRate; //店招费用 /年

    //租约相关
    @Column
    private Date nextPayRentDate; //下次交租日

    @Column
    private String maxRentYear; //最大可租年

    @Column
    private Integer repetition; //可以重复签约

    //评价
    @Column
    private Integer marchatLevel; //评价登记

    @Column
    private Integer houseLevel; //店铺评级

    @Column
    private String good;

    @Column
    private String bad;

    @Column
    private String proposed;

    @Column
    private Long perPersonMin; //建议人均 kaishi

    @Column
    private Long perPersonMax; //建议人均 jieshu


    //其它
    @Column
    private String describtion;

    @Column
    private Integer houseSource; //来源类型

    @Column
    private String sourceName;

    @Column
    private Integer status;

    @Column
    @UpdatedTimestamp
    private Date updated_date;

    @Column
    @CreatedTimestamp
    private Date created_date;

    @Column
    private Integer contactId;

//    @OneToOne(mappedBy = "houseShow")
    @Transient
    public Credential credential = new Credential();
    @Transient
    public List<Picture> pictures = new ArrayList<>();

    public House() {
        Date now = new Date();
        code = "S16" + now.getMonth() +now.getDate() + new Random(100000).nextInt();
        status = INIT;
    }

    public void FsetFacility(HouseFacilityForm form) {
        this.shopSignSizeOne = null == form.getShopSignSizeOne() ? 0l :form.getShopSignSizeOne();
        this.shopSignSizeTwo = null == form.getShopSignSizeTwo() ? 0l : form.getShopSignSizeTwo();
        this.power = null == form.getPower() ? 1 : form.getPower();
        this.capacitance = null == form.getCapacitance() ? "0" : form.getCapacitance();
        this.capacityIncrease = null == form.getCapacityIncrease() ? 0 : form.getCapacityIncrease();
        this.upPipe = null == form.getUpPipe() ? 1 : form.getUpPipe();
        this.downPipe = null == form.getDownPipe() ? 1 : form.getDownPipe();
        this.downPipeDiameter = null == form.getDownPipeDiameter() ? "0" : form.getDownPipeDiameter();
        this.gas = null == form.getGas() ? 1 : form.getGas();
        this.gasCylinders = null == form.getGasCylinders() ? 0 : form.getGasCylinders();
        this.fire = null == form.getFire() ? 1 : form.getFire() ;
        this.duct = null == form.getDuct() ? 1 : form.getDuct();
        this.ductRate = null == form.getDuctRate() ? 0l : form.getDuctRate();
        this.blowOff = null == form.getBlowOff() ? 1 : form.getBlowOff();
        this.greaseTrap = null == form.getGreaseTrap() ? 0 : form.getGreaseTrap();
        this.oilFume = null == form.getOilFume() ? 1 : form.getOilFume();
        this.selfCarPortSize = null == form.getSelfCarPortSize() ? 0 : form.getSelfCarPortSize();
        this.aroundCarPortSize = null == form.getAroundCarPortSize() ? 0 : form.getAroundCarPortSize();
        this.outWard = null == form.getOutWard() ? 0 : form.getOutWard();
    }

    public void FsetPosition(HousePositionForm position) {
        this.provinceCode = null == position.getProvinceCode() ? 0 : position.getProvinceCode();
        this.cityCode = null == position.getCityCode() ? 0 : position.getCityCode();
        this.areaCode = null == position.getAreaCode() ? 0 : position.getAreaCode();
        this.districtCode = null == position.getDistrictCode() ? 0 : position.getDistrictCode();
        this.address = null == position.getAddress() ? "" : position.getAddress();
        this.longitude = null == position.getLongitude() ? "" : position.getLongitude();
        this.latitude = null == position.getLatitude() ? "" : position.getLatitude();
        this.mapUrl = null == position.getMapUrl() ? "" : position.getMapUrl();
        this.mapUrlType = null == position.getMapUrlType() ? "" : position.getMapUrlType();
        this.wholeMapUrl = null == position.getWholeMapUrl() ? "" : position.getWholeMapUrl();
        this.hotMapUrl = null == position.getHotMapUrl() ? "" : position.getHotMapUrl();
    }

    public void setArea(HouseAreaForm area){
        this.houseType = null == area.getHouseType() ? 0 : area.getHouseType();
        this.ownerType = null == area.getOwnerType() ? 0 : area.getOwnerType();
        this.owner = null == area.getOwner() ? "" : area.getOwner();
        this.propertyRightType = null == area.getPropertyRightType() ? 0 : area.getPropertyRightType();
        this.floor = null == area.getFloor() ? "0" : area.getFloor();
        this.maxFloor = null == area.getMaxFloor() ? "0" : area.getMaxFloor();
        this.areas = null == area.getAreas() ? 0 : area.getAreas();
        this.effien = null == area.getEffien() ? 0 : area.getEffien();
        this.showLength = null == area.getShowLength() ? 0 : area.getShowLength();
        this.rentType = null == area.getRentType() ? 0 : area.getRentType();
        this.shade = null == area.getShade() ? 0 : area.getShade();
        this.decoration = null == area.getDecoration() ? 0 : area.getDecoration();
    }

    public void setCost(HouseCostForm cost){
        this.chummageDaily = null == cost.getChummageDaily() ? 0l :cost.getChummageDaily();
        this.chummageMonth = null == cost.getChummageMonth() ? 0l :cost.getChummageMonth();
        this.chummageYear = null == cost.getChummageYear() ? 0l :cost.getChummageYear();
        this.chummageIncrease = null == cost.getChummageIncrease() ? 0 :cost.getChummageIncrease();
        this.chummageIncreaseRule = null == cost.getChummageIncreaseRule() ? "" :cost.getChummageIncreaseRule();
        this.transferCost = null == cost.getTransferCost() ? 0l:cost.getTransferCost();
        this.pledgeMonth = null == cost.getDeposit() ? "" :cost.getDeposit();
        this.payMonth = null == cost.getPayMoney() ? "" :cost.getPayMoney();
        this.propertyFee = null == cost.getPropertyFee() ? 0l :cost.getPropertyFee();
        this.waterFee = null == cost.getWaterRate() ? 0l :cost.getWaterRate();
        this.gasFee = null == cost.getGasRate() ? 0l :cost.getGasRate();
        this.shopSignRate = null == cost.getShopSignRate() ? 0l :cost.getShopSignRate();
    }

    public void setEvaluate(HouseEvaluateForm evaluate){
        this.marchatLevel = null == evaluate.getMarchatLevel() ? 0 :evaluate.getMarchatLevel();
        this.houseLevel = null == evaluate.getHouseLevel() ? 0 :evaluate.getHouseLevel();
        this.good = null == evaluate.getGood() ? "" :evaluate.getGood();
        this.bad = null == evaluate.getBad() ? "" :evaluate.getBad();
        this.proposed = null == evaluate.getProposed() ? "" :evaluate.getProposed();
    }

    public void setRent(HouseRentForm rent){
        this.rentStatus = null == rent.getRentStatus() ? 0 : rent.getRentStatus();
        this.rentBusinessType = null == rent.getRentBusinessType() ? 0 : rent.getRentBusinessType();
    }

    public void setHouse(HouseForm house){
        this.business = null == house.getBusiness() ? "" : house.getBusiness();
        this.businessName = null == house.getBusinessName() ? "" : house.getBusinessName();
        this.businessStatus = null == house.getBusinessStatus() ? "" : house.getBusinessStatus();
        this.nextPayRentDate = null == house.getNextPayRentDate() ? new Date() : house.getNextPayRentDate();
        this.maxRentYear = null == house.getMaxRentYear() ? "" : house.getMaxRentYear();
        this.repetition = null == house.getRepetition() ? 0 : house.getRepetition();
        this.describtion = null == house.getDesc() ? "" : house.getDesc();
        this.houseSource = null == house.getHouseSource() ? 0 : house.getHouseSource();
        this.sourceName = null == house.getSourceName() ? "" : house.getSourceName();
        this.status = null == house.getStatus() ? 0 : house.getStatus();
    }


    //setter and getter

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRentBusinessType() {
        return rentBusinessType;
    }

    public void setRentBusinessType(Integer rentBusinessType) {
        this.rentBusinessType = rentBusinessType;
    }

    public Integer getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Integer rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getMapUrlType() {
        return mapUrlType;
    }

    public void setMapUrlType(String mapUrlType) {
        this.mapUrlType = mapUrlType;
    }

    public String getWholeMapUrl() {
        return wholeMapUrl;
    }

    public void setWholeMapUrl(String wholeMapUrl) {
        this.wholeMapUrl = wholeMapUrl;
    }

    public String getHotMapUrl() {
        return hotMapUrl;
    }

    public void setHotMapUrl(String hotMapUrl) {
        this.hotMapUrl = hotMapUrl;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPropertyRightType() {
        return propertyRightType;
    }

    public void setPropertyRightType(Integer propertyRightType) {
        this.propertyRightType = propertyRightType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(String maxFloor) {
        this.maxFloor = maxFloor;
    }

    public Long getAreas() {
        return areas;
    }

    public void setAreas(Long areas) {
        this.areas = areas;
    }

    public Long getEffien() {
        return effien;
    }

    public void setEffien(Long effien) {
        this.effien = effien;
    }

    public Integer getShowLength() {
        return showLength;
    }

    public void setShowLength(Integer showLength) {
        this.showLength = showLength;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }

    public Long getShade() {
        return shade;
    }

    public void setShade(Long shade) {
        this.shade = shade;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public Long getChummageDaily() {
        return chummageDaily;
    }

    public void setChummageDaily(Long chummageDaily) {
        this.chummageDaily = chummageDaily;
    }

    public Long getChummageMonth() {
        return chummageMonth;
    }

    public void setChummageMonth(Long chummageMonth) {
        this.chummageMonth = chummageMonth;
    }

    public Long getChummageYear() {
        return chummageYear;
    }

    public void setChummageYear(Long chummageYear) {
        this.chummageYear = chummageYear;
    }

    public Integer getChummageIncrease() {
        return chummageIncrease;
    }

    public void setChummageIncrease(Integer chummageIncrease) {
        this.chummageIncrease = chummageIncrease;
    }

    public String getChummageIncreaseRule() {
        return chummageIncreaseRule;
    }

    public void setChummageIncreaseRule(String chummageIncreaseRule) {
        this.chummageIncreaseRule = chummageIncreaseRule;
    }

    public Long getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(Long transferCost) {
        this.transferCost = transferCost;
    }

    public String getPledgeMonth() {
        return pledgeMonth;
    }

    public void setPledgeMonth(String pledgeMonth) {
        this.pledgeMonth = pledgeMonth;
    }

    public String getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
    }

    public Long getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Long propertyFee) {
        this.propertyFee = propertyFee;
    }

    public Long getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(Long waterFee) {
        this.waterFee = waterFee;
    }

    public Long getGasFee() {
        return gasFee;
    }

    public void setGasFee(Long gasFee) {
        this.gasFee = gasFee;
    }

    public Long getShopSignRate() {
        return shopSignRate;
    }

    public void setShopSignRate(Long shopSignRate) {
        this.shopSignRate = shopSignRate;
    }

    public Date getNextPayRentDate() {
        return nextPayRentDate;
    }

    public void setNextPayRentDate(Date nextPayRentDate) {
        this.nextPayRentDate = nextPayRentDate;
    }

    public String getMaxRentYear() {
        return maxRentYear;
    }

    public void setMaxRentYear(String maxRentYear) {
        this.maxRentYear = maxRentYear;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }

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

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public Integer getHouseSource() {
        return houseSource;
    }

    public void setHouseSource(Integer houseSource) {
        this.houseSource = houseSource;
    }

    public String getSourceName() {
        return sourceName;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOutWard() {
        return outWard;
    }

    public void setOutWard(Integer outWard) {
        this.outWard = outWard;
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

    public String getDownPipeDiameter() {
        return downPipeDiameter;
    }

    public void setDownPipeDiameter(String downPipeDiameter) {
        this.downPipeDiameter = downPipeDiameter;
    }

    public String getCapacitance() {
        return capacitance;
    }

    public void setCapacitance(String capacitance) {
        this.capacitance = capacitance;
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

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        if (null == pictures) return;
        this.pictures.addAll(pictures);
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public Long getBuildAreas() {
        return buildAreas;
    }

    public void setBuildAreas(Long buildAreas) {
        this.buildAreas = buildAreas;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getElasFee() {
        return elasFee;
    }

    public void setElasFee(Long elasFee) {
        this.elasFee = elasFee;
    }

    public Long getPerPersonMin() {
        return perPersonMin;
    }

    public void setPerPersonMin(Long perPersonMin) {
        this.perPersonMin = perPersonMin;
    }

    public Long getPerPersonMax() {
        return perPersonMax;
    }

    public void setPerPersonMax(Long perPersonMax) {
        this.perPersonMax = perPersonMax;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Long getUseAreas() {
        return useAreas;
    }

    public void setUseAreas(Long useAreas) {
        this.useAreas = useAreas;
    }

    public Integer getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(Integer operateStatus) {
        this.operateStatus = operateStatus;
    }
}