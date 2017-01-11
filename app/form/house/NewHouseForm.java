package form.house;

import form.BaseForm;
import helper.DateUtil;
import models.Contact;
import models.Credential;
import models.House;
import models.Signs;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/18 上午3:32
 * @Descrition:
 */
public class NewHouseForm extends BaseForm{

    /**
     * 资质
     */
    //营业执照
    private Integer businessLicence;
    //是否是大照
    private Integer wholeBusiness;
    //视频经营许可证
    private Integer foodAndBeverageBusinessLicense;
    //火安全
    private Integer fireSafetyPermission;
    //发票
    private Integer invoice;

    public Credential toCredential(){
        Credential credential = new Credential();
        credential.setBusinessLicence(this.businessLicence);
        credential.setWholeBusiness(this.wholeBusiness);
        credential.setFoodAndBeverageBusinessLicense(this.foodAndBeverageBusinessLicense);
        credential.setFireSafetyPermission(this.fireSafetyPermission);
        credential.setInvoice(this.invoice);
        return credential;
    }


    /**
     * 联系人
     */
    //姓名
    private String contactName;
    //联系人电话号码
    private String contactMobile;
    //联系人类型 默认是1
    private Integer contactType;


    public Contact toContact(){
        Contact contact = new Contact();
        contact.setMobile(this.contactMobile);
        contact.setName(this.contactName);
        contact.setType(this.contactType);
        return contact;
    }


    /**
     * 租售信息
     */
    //租售类型
    private Integer rentBusinessType = 0;
    //租售状态
    private Integer rentStatus = 0;


    /**
     * 标志物建筑
     */
    List<Signs> signs;

























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

    private String sign;

    private String hotMapUrl;

    private String mapUrl;



    //价格;
    private String chummageDaily;

    private String chummageMonth;

    private String chummageYear;

    private String transferCost;

    private String location;

    //房屋类型
    private Integer houseType;

    private String houseTypeName;

    //是否属于整租
    private Integer rentType;

    //品牌
    private String business; //经营业态

    private Integer operateStatus; //经营业态 //未营业 营业

    private String businessName; //经营品牌

    private String businessStatus; //当前业态(米粉/面条)

    private String contact;

    //当前状态

    //建筑信息
    //房屋类型
    private String owner; //房屋所有权
    private Integer ownerType;

    private String ownerTypeName;

    private Integer propertyRightType;

    private String propertyRightTypeName;

    private String areas; //建筑面积

    private String buildAreas; //建筑面积

    private String usedAreas; //建筑面积

    private Integer showLength; //展示面宽度

    private String floor; //第几层

    private String height;

    private String maxFloor; //一共几层

    private String shade; //遮挡程度

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

    private Integer capacitance; //电容量

    private Integer downPipeDiameter; //下水管直径

    private String ductRate; //排风量

    private Integer selfCarPortSize; //自由停车位

    private Integer aroundCarPortSize; //周边停车位

    private String shopSignSizeOne; //店招1

    private String shopSignSizeTwo;  //店招2

    private Integer decoration = 0; //0无, 1有装修

    private String decorationName; //0无, 1有装修

    //费用相关
    private Integer chummageIncrease; //租金递增

    private String chummageIncreaseRule; //租金递增规则

    private String deposit; //压几个月

    private String payMoney; //附几个月

    private String propertyFee; //物业费

    private String waterRate; //水费

    private String gasRate; //天然气费

    private String elasRate; //电费

    //租约相关
    private String nextPayRentDate; //下次交租日

    private String maxRentYear; //最大可租年

    private Integer repetition; //可以重复签约

    private Integer marchatLevel; //商圈登记

    private String marchatLevelName; //商圈登记

    private Integer houseLevel; //店铺评级

    private String houseLevelName; //店铺评级

    private String proposed; //建议业态

    private String perPersonMin; //建议人均 kaishi

    private String perPersonMax; //建议人均 jieshu

    private String good;

    private String bad;

    private Integer houseSource;

    private String houseSourceName;

    private String sourceName;

    private String describtion;


    public House toHouse(){
        House house = new House();
        house.setRentBusinessType(this.rentBusinessType);
        house.setRentStatus(this.rentStatus);
        house.setNextPayRentDate(DateUtil.string2DateSecond24(this.nextPayRentDate));
        house.setMaxRentYear(this.maxRentYear);
        house.setRepetition(this.repetition);
        house.setMarchatLevel(this.marchatLevel);
        house.setHouseLevel(this.houseLevel);
        house.setPerPersonMin(stringToLong(this.perPersonMin));
        house.setPerPersonMax(stringToLong(this.perPersonMax));
        house.setProposed(this.proposed);
        house.setGood(this.good);
        house.setBad(this.bad);
        house.setHouseSource(this.houseSource);
        house.setSourceName(this.sourceName);
        house.setDescribtion(this.describtion);
        pushBusiness(house);
        pushAddress(house);
        pushFacility(house);
        pushCharge(house);
        return house;
    }

    private void pushCharge(House house) {
        house.setChummageDaily(stringToLong(this.chummageDaily));
        house.setChummageMonth(stringToLong(this.chummageMonth));
        house.setChummageYear(stringToLong(this.chummageYear));
        house.setChummageIncrease(this.chummageIncrease);
        house.setChummageIncreaseRule(this.chummageIncreaseRule);
        house.setTransferCost(stringToLong(this.transferCost));
        house.setDeposit(this.deposit);
        house.setPayMoney(this.payMoney);
        house.setPropertyFee(stringToLong(this.propertyFee));
        house.setWaterRate(stringToLong(this.waterRate));
        house.setElasRate(stringToLong(this.elasRate));
        house.setGasRate(stringToLong(this.gasRate));
    }

    private void pushFacility(House house) {
        house.setShopSignSizeOne(stringToLong(this.shopSignSizeOne));
        house.setShopSignSizeTwo(stringToLong(this.shopSignSizeTwo));
        house.setPower(this.power); //动力电
        house.setCapacityIncrease(this.capacityIncrease);
        house.setUpPipe(this.upPipe);
        house.setDownPipe(this.downPipe);
        house.setBlowOff(this.blowOff);
        house.setGreaseTrap(this.greaseTrap);
        house.setFire(this.fire);
        house.setGas(this.gas);
        house.setGasCylinders(this.gasCylinders);
        house.setDuct(this.duct);
        house.setOilFume(this.oilFume);
        house.setOutWard(this.outWard);
        house.setCapacitance(this.capacitance);
        house.setDownPipeDiameter(this.downPipeDiameter);
        house.setDuctRate(stringToLong(this.ductRate));
        house.setSelfCarPortSize(this.selfCarPortSize);
        house.setAroundCarPortSize(this.aroundCarPortSize);

    }

    private void pushBusiness(House house) {
        house.setOperateStatus(this.operateStatus);
        house.setBusinessName(this.businessName);
        house.setHouseType(this.houseType);
        house.setOwner(this.owner);
        house.setOwnerType(this.ownerType);
        house.setPropertyRightType(this.propertyRightType);
        house.setFloor(this.floor);
        house.setMaxFloor(this.maxFloor);
        house.setAreas(stringToLong(this.areas));
        house.setBuildAreas(stringToLong(this.buildAreas));
        house.setUseAreas(null == this.usedAreas ? house.getBuildAreas() : stringToLong(this.usedAreas));
        house.setShowLength(this.showLength);
        house.setHeight(stringToLong(this.height));
        house.setShade(stringToLong(this.shade));
        house.setDecoration(this.decoration);
        house.setBusinessStatus(this.businessStatus);
        house.setRentType(this.rentType);
    }

    private void pushAddress(House house){
        house.setProvinceCode(this.provinceCode);
        house.setCityCode(this.cityCode);
        house.setAreaCode(this.areaCode);
        house.setAddress(this.address);
        house.setHotMapUrl("");
        house.setWholeMapUrl("");
        house.setMapUrl("");
        house.setSign(this.sign);
    }




    private Long stringToLong(String number){
        if (!StringUtils.isNumeric(number)) return 0l;
        Double result = Double.valueOf(number) * 100;
        return result.longValue();
    }


    //setter and getter

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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getChummageDaily() {
        return chummageDaily;
    }

    public void setChummageDaily(String chummageDaily) {
        this.chummageDaily = chummageDaily;
    }

    public String getChummageMonth() {
        return chummageMonth;
    }

    public void setChummageMonth(String chummageMonth) {
        this.chummageMonth = chummageMonth;
    }

    public String getChummageYear() {
        return chummageYear;
    }

    public void setChummageYear(String chummageYear) {
        this.chummageYear = chummageYear;
    }

    public String getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(String transferCost) {
        this.transferCost = transferCost;
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

    public Integer getFireSafetyPermission() {
        return fireSafetyPermission;
    }

    public void setFireSafetyPermission(Integer fireSafetyPermission) {
        this.fireSafetyPermission = fireSafetyPermission;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getBuildAreas() {
        return buildAreas;
    }

    public void setBuildAreas(String buildAreas) {
        this.buildAreas = buildAreas;
    }

    public String getUsedAreas() {
        return usedAreas;
    }

    public void setUsedAreas(String usedAreas) {
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(String maxFloor) {
        this.maxFloor = maxFloor;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
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

    public Integer getCapacitance() {
        return capacitance;
    }

    public void setCapacitance(Integer capacitance) {
        this.capacitance = capacitance;
    }

    public Integer getDownPipeDiameter() {
        return downPipeDiameter;
    }

    public void setDownPipeDiameter(Integer downPipeDiameter) {
        this.downPipeDiameter = downPipeDiameter;
    }

    public String getDuctRate() {
        return ductRate;
    }

    public void setDuctRate(String ductRate) {
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

    public String getShopSignSizeOne() {
        return shopSignSizeOne;
    }

    public void setShopSignSizeOne(String shopSignSizeOne) {
        this.shopSignSizeOne = shopSignSizeOne;
    }

    public String getShopSignSizeTwo() {
        return shopSignSizeTwo;
    }

    public void setShopSignSizeTwo(String shopSignSizeTwo) {
        this.shopSignSizeTwo = shopSignSizeTwo;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    public String getDecorationName() {
        return decorationName;
    }

    public void setDecorationName(String decorationName) {
        this.decorationName = decorationName;
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

    public String getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(String propertyFee) {
        this.propertyFee = propertyFee;
    }

    public String getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(String waterRate) {
        this.waterRate = waterRate;
    }

    public String getGasRate() {
        return gasRate;
    }

    public void setGasRate(String gasRate) {
        this.gasRate = gasRate;
    }

    public String getElasRate() {
        return elasRate;
    }

    public void setElasRate(String elasRate) {
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

    public String getPerPersonMin() {
        return perPersonMin;
    }

    public void setPerPersonMin(String perPersonMin) {
        this.perPersonMin = perPersonMin;
    }

    public String getPerPersonMax() {
        return perPersonMax;
    }

    public void setPerPersonMax(String perPersonMax) {
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Integer getWholeBusiness() {
        return wholeBusiness;
    }

    public void setWholeBusiness(Integer wholeBusiness) {
        this.wholeBusiness = wholeBusiness;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHotMapUrl() {
        return hotMapUrl;
    }

    public void setHotMapUrl(String hotMapUrl) {
        this.hotMapUrl = hotMapUrl;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public Integer getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(Integer operateStatus) {
        this.operateStatus = operateStatus;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }
}
