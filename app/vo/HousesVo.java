package vo;

import helper.Page;
import models.Contact;
import models.House;
import models.address.Area;
import models.address.City;
import models.address.District;
import models.enums.ContactEnums;
import models.enums.HouseEnums;
import services.AddressService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/19 下午4:06
 * @Descrition:
 */
public class HousesVo {

    private Integer id;

    //编号
    private String code;

    private Integer rentStatus = 0;
    private String rentStatusName;

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

    //房屋类型
    private Integer houseType;
    private String houseTypeName;

    //铺原等级
    private Integer houseLevel;
    private String houseLevelName;

    //带看次数
    private Integer showTimes;

    //面积
    private Long areas;

    private String floor;

    //价格;
    private Long chummageDaily;

    private Long chummageMonth;

    private Long transferCost;

    //品牌
    private String business; //经营业态

    private String businessName; //经营品牌

    private String businessStatus; //当前业态(米粉/面条)

    private String owner;

    private Integer ownerType;

    private String ownerTypeName;

    private String ownerMobile;

    private Integer sourceType;

    private String sourceTypeName;

    //更新时间
    private Long updatedTime;

    public HousesVo() {
    }

    public HousesVo(House house) {
        this.id = house.getId();
        this.code = house.getCode();
        this.cityCode = house.getCityCode();
        this.areaCode = house.getAreaCode();
        this.districtCode = house.getDistrictCode();
        this.address = house.getAddress();
        this.houseType = house.getHouseType();
        this.houseLevel = house.getHouseLevel();
        this.areas = house.getAreas();
        this.floor = house.getFloor();
        setChummageDaily(house.getChummageDaily());
        setChummageMonth(house.getChummageMonth());
        setTransferCost(house.getTransferCost());
        this.business = house.getBusiness();
        this.businessStatus = house.getBusinessStatus();
        Contact contact = Contact.finder.byId(house.getContactId());
        this.owner = null == contact ? "" : contact.getName();
        this.ownerType = null == contact ? 0 : contact.getType();
        this.ownerMobile = null == contact ? "" : contact.getMobile();
        this.sourceType = house.getHouseSource();
        this.updatedTime = house.getUpdatedDate().getTime();

    }

    public static Page<HousesVo> transformFromHouse(Page<House> housesP){
        List<House> houseList = housesP.getItems();
        List<HousesVo> result = new ArrayList<>();
        houseList.stream().forEach(house->{
            result.add(transform(house));
        });
        return new Page<HousesVo>(result, housesP.getPage(), housesP.getSize(), housesP.getTotalPage());
    }

    private static HousesVo transform(House house) {
        HousesVo vo = new HousesVo(house);
        vo.cityName = null == house.getCityCode() ? "" : AddressService.CITY_MAP.get(house.getCityCode()).getName();
        vo.districtName = null == house.getDistrictCode() ? "" : AddressService.DISTRICT_MAP.get(house.getDistrictCode()).getName();
        vo.areaName = null == house.getAreaCode() ? "" : AddressService.AREA_MAP.get(house.getAreaCode()).getName();
        vo.houseTypeName = null == house.getHouseType() ? "" : HouseEnums.houseTypeMap.getOrDefault(house.getHouseType(), "");
        vo.houseLevelName = null == house.getHouseLevel() ? "" : HouseEnums.houseLevelMap.getOrDefault(house.getHouseLevel(), "");
        vo.businessName = null == house.getBusiness() ? "" : HouseEnums.bussinessMap.getOrDefault(house.getBusiness(), "");
        vo.showTimes = 0;
        vo.ownerTypeName = null == vo.ownerType ? "" : ContactEnums.contactMap.getOrDefault(vo.ownerType, "");
        vo.sourceTypeName = null == house.getHouseSource() ? "" : HouseEnums.sourceMap.getOrDefault(house.getHouseSource(), "");
        vo.rentStatusName = null == house.getRentStatus() ? "" : HouseEnums.rentStatusMap.getOrDefault(house.getRentStatus(), "");
        return vo;
    }


    public void setChummageMonth(Long chummageMonth) {
        this.chummageMonth = chummageMonth / 1000000;
    }

    public void setTransferCost(Long transferCost) {
        this.transferCost = transferCost / 1000000;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(Integer showTimes) {
        this.showTimes = showTimes;
    }

    public Long getAreas() {
        return areas;
    }

    public void setAreas(Long areas) {
        this.areas = areas;
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

    public Long getTransferCost() {
        return transferCost;
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

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceTypeName() {
        return sourceTypeName;
    }

    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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
}
