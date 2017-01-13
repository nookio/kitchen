package vo;

import models.Contact;
import models.House;
import models.address.Area;
import models.address.City;
import models.address.District;
import models.address.Province;
import models.enums.CredentialEnums;
import models.enums.HouseEnums;

import java.util.Map;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/19 下午6:26
 * @Descrition:
 */
public class HouseVo {

    private String code; //商铺编号

    private Integer rentBusinessType = 0;

    private String rentBusinessTypeName;

    private Integer rentStatus = 0;

    private String rentStatusName;

    private Integer provinceCode;
    private String provinceName;

    //城市名字
    private Integer cityCode;
    private String cityName;

    //区域名字
    private Integer areaCode;
    private String areaName;

    //区域名字
    private Integer districtCode;
    private String districtName;

    //地址
    private String address;



    //价格;
    private Long chummageDaily;

    private Long chummageMonth;

    private Long chummageYear;

    private Long transferCost;

    private String location;

    //房屋类型
    private Integer houseType;

    private String houseTypeName;

    //品牌
    private String business; //经营业态

    private String businessName; //经营品牌

    private String businessStatus; //当前业态(米粉/面条)

    private String contact;


    //资质
    private Integer businessLicence;

    private String  businessLicenceName;

    private Integer foodAndBeverageBusinessLicense;

    private String foodAndBeverageBusinessLicenseName;

    private Integer fireSafetyPermition;

    private String fireSafetyPermitionName;

    private Integer invoice;

    private String invoiceName;


    //当前状态

    //建筑信息
    //房屋类型
    private String owner;
    private Integer ownerType;

    private String ownerTypeName;

    private Integer propertyRightType;

    private String propertyRightTypeName;

    private Long areas; //建筑面积

    private Long buildAreas; //建筑面积

    private Long usedAreas; //建筑面积

    private Integer showLength; //展示面宽度

    private String floor; //第几层

    private Long height;

    private String maxFloor; //一共几层

    private Long shade; //遮挡程度

    private Integer power; //是否有动力电

    private Integer capacityIncrease; //可以增容

    private Integer upPipe; //上水管

    private Integer downPipe; //下水管

    private Integer blowOff; //排污管道

    private Integer greaseTrap; //隔油池

    private Integer gas; //天然气

    private Integer gasCylinders; //煤气罐

    private Integer fire; //明火

    private Integer duct; //排烟道

    private Integer oilFume; //油烟过滤器

    private Integer outWard; //是否有外摆区

    private String capacitance; //电容量

    private String downPipeDiameter; //下水管直径

    private Long ductRate; //排风量

    private Integer selfCarPortSize; //自由停车位

    private Integer aroundCarPortSize; //周边停车位

    private Long shopSignSizeOne; //店招1

    private Long shopSignSizeTwo;  //店招2

    private Integer decoration = 0; //0无, 1有装修

    private String decorationName; //0无, 1有装修

    //费用相关
    private Integer chummageIncrease; //租金递增

    private String chummageIncreaseName; //租金递增

    private String chummageIncreaseRule; //租金递增规则

    private String deposit; //压几个月

    private String payMoney; //附几个月

    private Long propertyFee; //物业费

    private Long waterRate; //水费

    private Long gasRate; //天然气费

    private Long elasRate; //电费

    //租约相关
    private String nextPayRentDate; //下次交租日

    private String maxRentYear; //最大可租年

    private Integer repetition; //可以重复签约

    private String repetitionName; //可以重复签约

    private Integer marchatLevel; //商圈登记

    private String marchatLevelName; //商圈登记

    private Integer houseLevel; //店铺评级

    private String houseLevelName; //店铺评级

    private String proposed; //建议业态

    private Long perPersonMin; //建议人均
    private Long perPersonMax; //建议人均

    private String good;

    private String bad;

    private Integer houseSource;

    private String houseSourceName;

    private String sourceName;

    private String describtion;

    public HouseVo() {
    }

    public HouseVo(House house) {
        this.code = house.getCode();
        this.rentBusinessType = house.getRentBusinessType();
        this.rentStatus = house.getRentStatus();
        this.provinceCode = house.getProvinceCode();
        this.cityCode = house.getCityCode();
        this.areaCode = house.getAreaCode();
        this.districtCode = house.getDistrictCode();
        this.address = house.getAddress();
        setChummageDaily(house.getChummageDaily());
        setChummageMonth(house.getChummageMonth());
        setChummageYear(house.getChummageYear());
        setTransferCost(house.getTransferCost());
        this.houseType = house.getHouseType();
        this.business = house.getBusiness();
        this.businessName = house.getBusinessName();
        this.businessStatus = house.getBusinessStatus();
        this.businessLicence = house.getCredential().getBusinessLicence();
        this.foodAndBeverageBusinessLicense = house.getCredential().getFoodAndBeverageBusinessLicense();
        this.fireSafetyPermition = house.getCredential().getFireSafetyPermission();
        this.invoice = house.getCredential().getInvoice();
        this.owner = house.getOwner();
        this.ownerType = house.getOwnerType();
        this.propertyRightType = house.getPropertyRightType();
        this.areas = house.getAreas();
        this.buildAreas = house.getBuildAreas();
        this.usedAreas = house.getBuildAreas();
        this.showLength = house.getShowLength();
        this.floor = house.getFloor();
        this.height = house.getHeight();
        this.maxFloor = house.getMaxFloor();
        this.shade = house.getShade();
        this.power = house.getPower();
        this.capacityIncrease = house.getCapacityIncrease();
        this.upPipe = house.getUpPipe();
        this.downPipe = house.getDownPipe();
        this.blowOff = house.getBlowOff();
        this.greaseTrap = house.getGreaseTrap();
        this.gas = house.getGas();
        this.gasCylinders = house.getGasCylinders();
        this.fire = house.getFire();
        this.duct = house.getDuct();
        this.oilFume = house.getOilFume();
        this.outWard = house.getOutWard();
        this.capacitance = house.getCapacitance();
        this.downPipeDiameter = house.getDownPipeDiameter();
        this.ductRate = house.getDuctRate();
        this.selfCarPortSize = house.getSelfCarPortSize();
        this.aroundCarPortSize = house.getAroundCarPortSize();
        this.shopSignSizeOne = house.getShopSignSizeOne();
        this.shopSignSizeTwo = house.getShopSignSizeTwo();
        this.chummageIncrease = house.getChummageIncrease();
        this.chummageIncreaseRule = house.getChummageIncreaseRule();
        this.deposit = house.getPledgeMonth();
        this.payMoney = house.getPayMonth();
        this.propertyFee = house.getPropertyFee();
        this.waterRate = house.getWaterFee();
        this.gasRate = house.getGasFee();
        this.elasRate = house.getElasFee();
        this.nextPayRentDate = null == house.getNextPayRentDate() ? "": house.getNextPayRentDate().toString();
        this.maxRentYear = house.getMaxRentYear();
        this.repetition = house.getRepetition();
        this.marchatLevel = house.getMarchatLevel();
        this.houseLevel = house.getHouseLevel();
        this.proposed = house.getProposed();
        this.perPersonMin = house.getPerPersonMin();
        this.perPersonMax = house.getPerPersonMax();
        this.good = house.getGood();
        this.bad = house.getBad();
        this.houseSource = house.getHouseSource();
        this.sourceName = house.getSourceName();
        this.describtion = house.getDescribtion();
    }

    public static HouseVo transformFromHouse(House house, Contact contact, Map<Integer, Province> provinces,
                                             Map<Integer, City> citys,
                                             Map<Integer, Area> areas, Map<Integer, District> districts) {

        HouseVo vo = new HouseVo(house);
        vo.houseTypeName = null == house.getHouseType() ? "" : HouseEnums.houseTypeMap.getOrDefault(house.getHouseType(), "");
        vo.ownerTypeName = null == vo.ownerType ? "" : HouseEnums.ownerTypeMap.getOrDefault(vo.ownerType, "");
        vo.houseLevelName = null == house.getHouseLevel() ? "" : HouseEnums.houseLevelMap.getOrDefault(house.getHouseLevel(), "");
        vo.rentBusinessTypeName = 0 == vo.rentBusinessType ? "" : HouseEnums.bussinessMap.getOrDefault(vo.rentBusinessType, "");
        vo.rentStatusName = null == house.getRentStatus() ? "" : HouseEnums.rentStatusMap.getOrDefault(house.getRentStatus(), "");

        vo.businessLicenceName = null == vo.businessLicence ? "" : CredentialEnums.businessLicenceMap.getOrDefault(vo.businessLicence, "");
        vo.foodAndBeverageBusinessLicenseName = null == vo.foodAndBeverageBusinessLicense ? "" : CredentialEnums.foodLicenceMap.getOrDefault(vo.foodAndBeverageBusinessLicense, "");
        vo.fireSafetyPermitionName = null == vo.fireSafetyPermition ? "" : CredentialEnums.fireLicenceMap.getOrDefault(vo.fireSafetyPermition, "");;
        vo.invoiceName = null == vo.invoice ? "" : CredentialEnums.invoiceMap.getOrDefault(vo.invoice, "");;

        vo.repetitionName = 0 == vo.getRepetition() ? "否" : "是";
        vo.chummageIncreaseName = 1 == vo.getChummageIncrease() ?  "是" : "否";

        vo.propertyRightTypeName = null == vo.propertyRightType ? "" : HouseEnums.propertyRightTypeMap.getOrDefault(vo.propertyRightType, "");
        vo.marchatLevelName = null == vo.marchatLevel ? "" : HouseEnums.houseLevelMap.getOrDefault(vo.marchatLevel, "");
        vo.houseSourceName = null == vo.houseSource ? "" : HouseEnums.sourceMap.getOrDefault(vo.sourceName, "");
        vo.provinceName = null == vo.provinceCode ? "" : provinces.get(vo.getProvinceCode()).getName();
        vo.cityName = null == vo.getCityCode() ? "" : citys.get(vo.getCityCode()).getName();
        vo.districtName = null == vo.getDistrictCode() ? "" : districts.get(vo.getDistrictCode()).getName();
        vo.areaName = null == vo.getAreaCode() ? "" : areas.get(vo.getAreaCode()).getName();
        vo.decorationName = 0 == vo.getDecoration() ?  "否" : "是";
        vo.houseSourceName = null == vo.getHouseSource() ? "" : HouseEnums.sourceMap.getOrDefault(vo.getHouseSource(), "");
        vo.setLocation(vo.provinceName, vo.cityName, vo.areaName, vo.districtName, vo.address);
        vo.setContact(contact.getName(), contact.getType(), contact.getMobile());
        return vo;
    }

    public void setLocation(String provinceName,String cityName, String areaName, String districtName, String address){
        this.location = provinceName + "-" + cityName + "-" +  areaName + "-" +  districtName + "-" +  address;
    }

    public void setContact(String owner, Integer ownerType, String mobile){
        this.contact = owner + " " + (
                null == ownerType ? "" : HouseEnums.sourceMap.getOrDefault(ownerType, ""))
                + "  " + mobile;
    }

    public void setChummageMonth(Long chummageMonth) {
        this.chummageMonth = chummageMonth / 1000000;
    }

    public void setTransferCost(Long transferCost) {
        this.transferCost = transferCost / 1000000;
    }

    public void setChummageYear(Long chummageYear) {
        this.chummageYear = chummageYear / 1000000;
    }

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

    public String getRentBusinessTypeName() {
        return rentBusinessTypeName;
    }

    public void setRentBusinessTypeName(String rentBusinessTypeName) {
        this.rentBusinessTypeName = rentBusinessTypeName;
    }

    public Integer getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Integer rentStatus) {
        this.rentStatus = rentStatus;
    }

    public String getRentStatusName() {
        return rentStatusName;
    }

    public void setRentStatusName(String rentStatusName) {
        this.rentStatusName = rentStatusName;
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

    public Long getChummageYear() {
        return chummageYear;
    }

    public Long getTransferCost() {
        return transferCost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName;
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

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(Integer businessLicence) {
        this.businessLicence = businessLicence;
    }

    public String getBusinessLicenceName() {
        return businessLicenceName;
    }

    public void setBusinessLicenceName(String businessLicenceName) {
        this.businessLicenceName = businessLicenceName;
    }

    public Integer getFoodAndBeverageBusinessLicense() {
        return foodAndBeverageBusinessLicense;
    }

    public void setFoodAndBeverageBusinessLicense(Integer foodAndBeverageBusinessLicense) {
        this.foodAndBeverageBusinessLicense = foodAndBeverageBusinessLicense;
    }

    public String getFoodAndBeverageBusinessLicenseName() {
        return foodAndBeverageBusinessLicenseName;
    }

    public void setFoodAndBeverageBusinessLicenseName(String foodAndBeverageBusinessLicenseName) {
        this.foodAndBeverageBusinessLicenseName = foodAndBeverageBusinessLicenseName;
    }

    public Integer getFireSafetyPermition() {
        return fireSafetyPermition;
    }

    public void setFireSafetyPermition(Integer fireSafetyPermition) {
        this.fireSafetyPermition = fireSafetyPermition;
    }

    public String getFireSafetyPermitionName() {
        return fireSafetyPermitionName;
    }

    public void setFireSafetyPermitionName(String fireSafetyPermitionName) {
        this.fireSafetyPermitionName = fireSafetyPermitionName;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerTypeName() {
        return ownerTypeName;
    }

    public void setOwnerTypeName(String ownerTypeName) {
        this.ownerTypeName = ownerTypeName;
    }

    public Integer getPropertyRightType() {
        return propertyRightType;
    }

    public void setPropertyRightType(Integer propertyRightType) {
        this.propertyRightType = propertyRightType;
    }

    public String getPropertyRightTypeName() {
        return propertyRightTypeName;
    }

    public void setPropertyRightTypeName(String propertyRightTypeName) {
        this.propertyRightTypeName = propertyRightTypeName;
    }

    public Long getAreas() {
        return areas;
    }

    public void setAreas(Long areas) {
        this.areas = areas;
    }

    public Long getBuildAreas() {
        return buildAreas;
    }

    public void setBuildAreas(Long buildAreas) {
        this.buildAreas = buildAreas;
    }

    public Long getUsedAreas() {
        return usedAreas;
    }

    public void setUsedAreas(Long usedAreas) {
        this.usedAreas = usedAreas;
    }

    public Integer getShowLength() {
        return showLength;
    }

    public void setShowLength(Integer showLength) {
        this.showLength = showLength;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public String getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(String maxFloor) {
        this.maxFloor = maxFloor;
    }

    public Long getShade() {
        return shade;
    }

    public void setShade(Long shade) {
        this.shade = shade;
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

    public Integer getOilFume() {
        return oilFume;
    }

    public void setOilFume(Integer oilFume) {
        this.oilFume = oilFume;
    }

    public Integer getOutWard() {
        return outWard;
    }

    public void setOutWard(Integer outWard) {
        this.outWard = outWard;
    }

    public Long getDuctRate() {
        return ductRate;
    }

    public void setDuctRate(Long ductRate) {
        this.ductRate = ductRate;
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

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public Long getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Long propertyFee) {
        this.propertyFee = propertyFee;
    }

    public Long getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(Long waterRate) {
        this.waterRate = waterRate;
    }

    public Long getGasRate() {
        return gasRate;
    }

    public void setGasRate(Long gasRate) {
        this.gasRate = gasRate;
    }

    public Long getElasRate() {
        return elasRate;
    }

    public void setElasRate(Long elasRate) {
        this.elasRate = elasRate;
    }

    public String getNextPayRentDate() {
        return nextPayRentDate;
    }

    public void setNextPayRentDate(String nextPayRentDate) {
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

    public String getMarchatLevelName() {
        return marchatLevelName;
    }

    public void setMarchatLevelName(String marchatLevelName) {
        this.marchatLevelName = marchatLevelName;
    }

    public Integer getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(Integer houseLevel) {
        this.houseLevel = houseLevel;
    }

    public String getHouseLevelName() {
        return houseLevelName;
    }

    public void setHouseLevelName(String houseLevelName) {
        this.houseLevelName = houseLevelName;
    }

    public String getProposed() {
        return proposed;
    }

    public void setProposed(String proposed) {
        this.proposed = proposed;
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

    public Integer getHouseSource() {
        return houseSource;
    }

    public void setHouseSource(Integer houseSource) {
        this.houseSource = houseSource;
    }

    public String getHouseSourceName() {
        return houseSourceName;
    }

    public void setHouseSourceName(String houseSourceName) {
        this.houseSourceName = houseSourceName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public String getDecorationName() {
        return decorationName;
    }

    public void setDecorationName(String decorationName) {
        this.decorationName = decorationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getChummageIncreaseName() {
        return chummageIncreaseName;
    }

    public void setChummageIncreaseName(String chummageIncreaseName) {
        this.chummageIncreaseName = chummageIncreaseName;
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

    public String getRepetitionName() {
        return repetitionName;
    }

    public void setRepetitionName(String repetitionName) {
        this.repetitionName = repetitionName;
    }
}
