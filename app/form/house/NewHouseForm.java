package form.house;

import form.BaseForm;
import helper.DateUtil;
import models.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private Integer businessLicence = 0;
    //是否是大照
    private Integer wholeBusiness = 0;
    //视频经营许可证
    private Integer foodAndBeverageBusinessLicense = 0;
    //火安全
    private Integer fireSafetyPermission = 0;
    //发票
    private Integer invoice = 0;

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
    private String contactName = "";
    //联系人电话号码
    private String contactMobile = "";
    //联系人类型 默认是1
    private Integer contactType = 1;


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
    private Integer rentBusinessType = 1;
    //租售状态
    private Integer rentStatus = 1;

    public void pushRentInfo(House house){
        house.setRentBusinessType(this.rentBusinessType);
        house.setRentStatus(this.rentStatus);
    }


    /**
     * 位置信息
     */
    //省
    private Integer provinceCode = 110000;
    //城市名字
    private Integer cityCode = 110100;
    //区域名字
    private Integer areaCode = 110101;
    //区域名字
    private Integer districtCode = 0;
    //地址
    private String address = "";
    //标志建筑物
    List<Integer> signs = new ArrayList<>();
    //地图url
    private String mapUrl = "";
    //全景地图
    private String wholeMapUrl = "";
    //热力地图:预留 todo
    private String hotMapUrl = "";

    public List<Signs> toSign(){
        if (null == signs || signs.size() == 0) return Collections.EMPTY_LIST;
        return signs.stream().map(sign -> new Signs(sign)).collect(Collectors.toList());
    }

    private void pushAddress(House house){
        house.setProvinceCode(this.provinceCode);
        house.setCityCode(this.cityCode);
        house.setAreaCode(this.areaCode);
        house.setDistrictCode(this.districtCode);
        house.setAddress(this.address);
        house.setHotMapUrl(hotMapUrl);
        house.setWholeMapUrl(wholeMapUrl);
        house.setMapUrl(mapUrl);
    }

    /**
     * 当前状态
     */
    //经营业态 //未营业 营业
    private Integer operateStatus = 0;
    //经营品牌
    private String businessName = "";
    //当前业态(米粉/面条) //todo 暂时有问题。
    private List<Integer> businessStatus = new ArrayList<>();

    public void pushStatus(House house){
        house.setOperateStatus(this.operateStatus);
        house.setBusinessName(this.businessName);
    }

    /**
     * 建筑信息
     */
    //图片地址
    private List<String> pictures;

//    public List<Picture> toPicture(){
//        if (null == pictures || pictures.size() == 0) return Collections.EMPTY_LIST;
//        List<Picture> result = new ArrayList<>();
//        return pictures.stream().map(picUrl -> new Picture(picUrl)).collect(Collectors.toList());
//    }

    //商铺类型 todo,待确认
    private Integer houseType = 1;
    //产权人
    private String owner = "";
    //产权人类型
    private Integer ownerType = 1;
    //房屋规划用途
    private Integer propertyRightType = 1;
    //第几层
    private String floor = "1";
    //建筑面积
    private String areas = "0";
    //建筑面积
    private String buildAreas = "0";
    //使用面积
    private String useAreas = "0";
    //展示面宽度
    private String showLength = "0";
    //层高
    private String height = "0";
    //遮挡程度
    private String shade = "0";
    //0无, 1有装修
    private Integer decoration = 0;

    public void pushBuildInfo(House house){
        house.setHouseType(this.houseType);
        house.setOwner(this.owner);
        house.setOwnerType(this.ownerType);
        house.setPropertyRightType(propertyRightType);
        house.setFloor(this.floor);
        house.setAreas(StringUtils.isNumeric(areas) ? Long.valueOf(this.areas) : 0l);
        house.setBuildAreas(StringUtils.isNumeric(buildAreas) ? Long.valueOf(this.buildAreas) : 0l);
        house.setUseAreas(StringUtils.isNumeric(useAreas) ? Long.valueOf(this.useAreas) : 0l);
        house.setShowLength(this.showLength);
        house.setHeight(StringUtils.isNumeric(this.height) ? Long.valueOf(this.height) : 0l);
        house.setShade(StringUtils.isNumeric(this.shade) ? Long.valueOf(this.shade) : 0l);
        house.setDecoration(this.decoration);
    }

    /**
     * 配套设施
     */
    //店招1
    private String shopSignSizeOne;
    //店招2
    private String shopSignSizeTwo;
    //配套设施 todo
    private List<Integer> facilities;
    //电容量
    private String capacitance;
    //下水管直径
    private String downPipeDiameter;
    //排风量
    private String ductRate;
    //自由停车位
    private Integer selfCarPortSize;
    //周边停车位
    private Integer aroundCarPortSize;

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

    /**
     * 费用相关
     */
    //日租金 分为单位
    private Long chummageDaily = 0l;
    //月租金
    private Long chummageMonth = 0l;
    //年租金
    private Long chummageYear = 0l;
    //租金递增
    private Integer chummageIncrease = 0;
    //租金递增规则
    private String chummageIncreaseRule = "";
    //转让费
    private Long transferCost = 0l;
    //压几个月
    private String pledgeMonth = "0";
    //附几个月
    private String payMonth = "0";
    //物业费
    private Long propertyFee = 0l;
    //水费
    private Long waterFee = 0l;
    //电费
    private Long elasFee = 0l;
    //天然气费
    private Long gasFee = 0l;

    private void pushCharge(House house) {
        house.setChummageDaily(this.chummageDaily);
        house.setChummageMonth(this.chummageMonth);
        house.setChummageYear(this.chummageYear);
        house.setChummageIncrease(this.chummageIncrease);
        house.setChummageIncreaseRule(this.chummageIncreaseRule);
        house.setTransferCost(this.transferCost);
        house.setPledgeMonth(this.pledgeMonth);
        house.setPayMonth(this.payMonth);
        house.setPropertyFee(this.propertyFee);
        house.setWaterFee(this.waterFee);
        house.setElasFee(this.elasFee);
        house.setGasFee(this.gasFee);
    }

    /**
     * 租约相关
     */
    //下次交租日
    private Long nextPayRentDate = -1l;
    //最大可租年
    private String maxRentYear = "0";
    //可以重复签约
    private Integer repetition = 0;

    public void pushRent(House house){
        house.setNextPayRentDate(new Date(this.nextPayRentDate));
        house.setMaxRentYear(this.maxRentYear);
        house.setRepetition(this.repetition);
    }

    /**
     * 评价相关
     */
    //商圈登记
    private Integer marchatLevel = 10;
    //店铺评级
    private Integer houseLevel = 10;
    //建议人均 kaishi
    private Long perPersonMin = 0l;
    //建议人均 jieshu
    private Long perPersonMax = 0l;
    //建议业态 todo
    private List<Integer> businesss;
    //优点
    private String good;
    //缺点
    private String bad;

    public void pushEvelate(House house){
        house.setMarchatLevel(this.marchatLevel);
        house.setHouseLevel(this.houseLevel);
        house.setPerPersonMin(this.perPersonMin);
        house.setPerPersonMax(this.perPersonMax);
        house.setGood(this.good);
        house.setBad(this.bad);
    }

    /**
     * 来源
     */
    private Integer houseSource = 8;

    private String sourceName = "其他";

    private String describtion = "";

    public void pushSource(House house){
        house.setHouseSource(this.houseSource);
        house.setSourceName(this.sourceName);
        house.setDescribtion(this.describtion);
    }


    /**
     * 多余字段
     */

    //价格;

    private String location;

    //房屋类型

    //是否属于整租
    private Integer rentType;

    //品牌
    private String business; //经营业态

    private String contact;

    //当前状态

    //建筑信息
    //房屋类型

    private String maxFloor; //一共几层

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

    private String proposed; //建议业态


    public House toHouse(){
        House house = new House();
        pushStatus(house);
        pushAddress(house);
        pushFacility(house);
        pushCharge(house);
        pushRentInfo(house);
        pushBuildInfo(house);
        pushRent(house);
        pushEvelate(house);
        pushSource(house);
        return house;
    }






    private Long stringToLong(String number){
        if (!StringUtils.isNumeric(number)) return 0l;
        Double result = Double.valueOf(number) * 100;
        return result.longValue();
    }


    //setter and getter


    public Integer getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(Integer businessLicence) {
        this.businessLicence = businessLicence;
    }

    public Integer getWholeBusiness() {
        return wholeBusiness;
    }

    public void setWholeBusiness(Integer wholeBusiness) {
        this.wholeBusiness = wholeBusiness;
    }

    public Integer getFoodAndBeverageBusinessLicense() {
        return foodAndBeverageBusinessLicense;
    }

    public void setFoodAndBeverageBusinessLicense(Integer foodAndBeverageBusinessLicense) {
        this.foodAndBeverageBusinessLicense = foodAndBeverageBusinessLicense;
    }

    public Integer getFireSafetyPermission() {
        return fireSafetyPermission;
    }

    public void setFireSafetyPermission(Integer fireSafetyPermission) {
        this.fireSafetyPermission = fireSafetyPermission;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
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

    public List<Integer> getSigns() {
        return signs;
    }

    public void setSigns(List<Integer> signs) {
        this.signs = signs;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
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

    public Integer getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(Integer operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<Integer> getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(List<Integer> businessStatus) {
        this.businessStatus = businessStatus;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
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

    public String getUseAreas() {
        return useAreas;
    }

    public void setUseAreas(String useAreas) {
        this.useAreas = useAreas;
    }

    public String getShowLength() {
        return showLength;
    }

    public void setShowLength(String showLength) {
        this.showLength = showLength;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
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

    public List<Integer> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Integer> facilities) {
        this.facilities = facilities;
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

    public Long getElasFee() {
        return elasFee;
    }

    public void setElasFee(Long elasFee) {
        this.elasFee = elasFee;
    }

    public Long getGasFee() {
        return gasFee;
    }

    public void setGasFee(Long gasFee) {
        this.gasFee = gasFee;
    }

    public Long getNextPayRentDate() {
        return nextPayRentDate;
    }

    public void setNextPayRentDate(Long nextPayRentDate) {
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

    public List<Integer> getBusinesss() {
        return businesss;
    }

    public void setBusinesss(List<Integer> businesss) {
        this.businesss = businesss;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRentType() {
        return rentType;
    }

    public void setRentType(Integer rentType) {
        this.rentType = rentType;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(String maxFloor) {
        this.maxFloor = maxFloor;
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

    public String getProposed() {
        return proposed;
    }

    public void setProposed(String proposed) {
        this.proposed = proposed;
    }
}
