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

    public void pushRentInfo(House house){
        house.setRentBusinessType(this.rentBusinessType);
        house.setRentStatus(this.rentStatus);
    }


    /**
     * 位置信息
     */
    //省
    private Integer provinceCode;
    //城市名字
    private Integer cityCode;
    //区域名字
    private Integer areaCode;
    //区域名字
    private Integer districtCode;
    //地址
    private String address;
    //标志建筑物
    List<Integer> signs;
    //地图url
    private String mapUrl;
    //全景地图
    private String wholeMapUrl;
    //热力地图:预留 todo
    private String hotMapUrl;

    public List<Signs> toSign(){
        if (null == signs || signs.size() == 0) return Collections.EMPTY_LIST;
        List<Signs> result = new ArrayList<>();
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
    private Integer operateStatus;
    //经营品牌
    private String businessName;
    //当前业态(米粉/面条) //暂时有问题。
    private List<Integer> businessStatus;

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
    private List<Integer> houseTypes;
    //产权人
    private String owner;
    //产权人类型
    private Integer ownerType;
    //房屋规划用途
    private Integer propertyRightType = 1;
    //第几层
    private String floor;
    //建筑面积
    private String areas;
    //建筑面积
    private String buildAreas;
    //使用面积
    private String useAreas;
    //展示面宽度
    private Integer showLength;
    //层高
    private String height;
    //遮挡程度
    private String shade;
    //0无, 1有装修
    private Integer decoration = 0;

    public void pushBuildInfo(House house){
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
    private Long chummageDaily;
    //月租金
    private Long chummageMonth;
    //年租金
    private Long chummageYear;
    //租金递增
    private Integer chummageIncrease;
    //租金递增规则
    private String chummageIncreaseRule;
    //转让费
    private Long transferCost;
    //压几个月
    private String pledgeMonth;
    //附几个月
    private String payMonth;
    //物业费
    private Long propertyFee;
    //水费
    private Long waterFee;
    //电费
    private Long elasFee;
    //天然气费
    private Long gasFee;

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
    private Long nextPayRentDate;
    //最大可租年
    private String maxRentYear;
    //可以重复签约
    private Integer repetition;

    public void pushRent(House house){
        house.setNextPayRentDate(new Date(this.nextPayRentDate));
        house.setMaxRentYear(this.maxRentYear);
        house.setRepetition(this.repetition);
    }

    /**
     * 评价相关
     */
    //商圈登记
    private Integer marchatLevel;
    //店铺评级
    private Integer houseLevel;
    //建议人均 kaishi
    private Long perPersonMin;
    //建议人均 jieshu
    private Long perPersonMax;
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
    private Integer houseSource;

    private String sourceName;

    private String describtion;

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
    private Integer houseType;

    private String houseTypeName;

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
        return house;
    }






    private Long stringToLong(String number){
        if (!StringUtils.isNumeric(number)) return 0l;
        Double result = Double.valueOf(number) * 100;
        return result.longValue();
    }


    //setter and getter

}
