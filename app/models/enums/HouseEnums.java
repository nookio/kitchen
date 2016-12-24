package models.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/8 下午2:12
 * @Descrition:
 */
public class HouseEnums {
    public static Map<Integer, String> bussinessMap = new HashMap<>();
    public static Map<Integer, String> houseTypeMap = new HashMap<>();
    public static Map<Integer, String> ownerTypeMap = new HashMap<>();
    public static Map<Integer, String> propertyRightTypeMap = new HashMap<>();
    public static Map<Integer, String> houseLevelMap = new HashMap<>();
    public static Map<Integer, String> sourceMap = new HashMap<>();
    public static Map<Integer, String> rentStatusMap = new HashMap<>();

    /**
     * 1-出租
     * 2-出售
     3-独家出租
     4-独家出售
     5-自营出租
     6-自营出售
     7-其他
     */
    public static final Integer BUSSINESS_FOR_RENT = 1;
    public static final Integer BUSSINESS_FOR_SOLD = 2;
    public static final Integer BUSSINESS_EXCLUSIVE_FOR_RENT = 3;
    public static final Integer BUSSINESS_EXCLUSIVE_FOR_SOLD = 4;
    public static final Integer BUSSINESS_SELF_FOR_RENT = 5;
    public static final Integer BUSSINESS_SELF_FOR_SOLD = 6;
    public static final Integer BUSSINESS_OTHERS = 7;

    static {
        bussinessMap.put(1, "出租");
        bussinessMap.put(2, "出售");
        bussinessMap.put(3, "独家出租");
        bussinessMap.put(4, "独家出售");
        bussinessMap.put(5, "自营出租");
        bussinessMap.put(6, "自营出售");
        bussinessMap.put(7, "其它");
    }

    /**
     * 1-写字楼配套
     2-商场/购物中心
     3-临街店铺
     4-社区配套
     5-商业街
     6-档口
     7-其他
     */
    public static final Integer HOUSE_TYPE_OFFICE_BUILDING = 1;
    public static final Integer HOUSE_TYPE_MARKET = 2;
    public static final Integer HOUSE_TYPE_FRONTAGE = 3;
    public static final Integer HOUSE_TYPE_COMMUNITY = 4;
    public static final Integer HOUSE_TYPE_BUSSINESS_STREET = 5;
    public static final Integer HOUSE_TYPE_STALLS = 6;
    public static final Integer HOUSE_TYPE_OTHERS = 7;

    static {
        houseTypeMap.put(1, "写字楼配套");
        houseTypeMap.put(2, "商场/购物中心");
        houseTypeMap.put(3, "临街配套");
        houseTypeMap.put(4, "社区配套");
        houseTypeMap.put(5, "商业街");
        houseTypeMap.put(6, "档口");
        houseTypeMap.put(7, "其它");
    }

    /**
     * 1-个人
     2-私营企业/合资企业
     3-外资企业
     4-国有企业/集体所有制企业
     5-政府
     6-事业单位
     7-社会组织
     8-其他
     */
    public static final Integer OWNER_TYPE_PERSONAL = 1;
    public static final Integer OWNER_TYPE_PRIVATE = 2;
    public static final Integer OWNER_TYPE_FROEIGN = 3;
    public static final Integer OWNER_TYPE_NATIONALIZED = 4;
    public static final Integer OWNER_TYPE_GOVERNMENT = 5;
    public static final Integer OWNER_TYPE_INSTITUTION = 6;
    public static final Integer OWNER_TYPE_SOCIAL_ORGANIZATION = 7;
    public static final Integer OWNER_TYPE_OTHERS = 8;

    static {
        ownerTypeMap.put(1, "个人");
        ownerTypeMap.put(2, "私营企业/合资企业");
        ownerTypeMap.put(3, "外资企业");
        ownerTypeMap.put(4, "国有企业/集体所有制企业");
        ownerTypeMap.put(5, "政府");
        ownerTypeMap.put(6, "事业单位");
        ownerTypeMap.put(7, "社会组织");
        ownerTypeMap.put(8, "其他");
    }

    /**
     * 01-商业（默认）
     02-办公
     03-住宅
     04-文物
     05-集体宿舍
     06-工业
     07-公用设施
     08-交通
     09-仓储
     10-信息
     11-教育科研
     12-医疗卫生
     13-文化新闻娱乐体育
     14-园林绿化
     15-军事
     16-物业公共配套
     17-物业服务
     18-社区服务
     19-汽车库
     20-车位
     21-自行车库
     22-储藏室
     23-外事
     24-宗教
     25-监狱
     26-保安
     27-社会福利
     28-其他
     */
    public static final Integer PROPERTY_RIGHT_TYPE_BUSSINESS = 1;
    public static final Integer PROPERTY_RIGHT_TYPE_OFFICE = 2;
    public static final Integer PROPERTY_RIGHT_TYPE_APARTMENT = 3;
    public static final Integer PROPERTY_RIGHT_TYPE_HISTORIAL = 4;
    public static final Integer PROPERTY_RIGHT_TYPE_DORM = 5;
    public static final Integer PROPERTY_RIGHT_TYPE_INDUSTRY = 6;
    public static final Integer PROPERTY_RIGHT_TYPE_PUBLIC_FACILITY= 7;
    public static final Integer PROPERTY_RIGHT_TYPE_TRAFFIC = 8;
    public static final Integer PROPERTY_RIGHT_TYPE_STORE_HOUSE = 9;
    public static final Integer PROPERTY_RIGHT_TYPE_NEWS = 10;
    public static final Integer PROPERTY_RIGHT_TYPE_EDUCATION = 11;
    public static final Integer PROPERTY_RIGHT_TYPE_MEDICAL = 12;
    public static final Integer PROPERTY_RIGHT_TYPE_ENTERTAINMENT = 13;
    public static final Integer PROPERTY_RIGHT_TYPE_GRARDEN = 14;
    public static final Integer PROPERTY_RIGHT_TYPE_MILITARY = 15;
    public static final Integer PROPERTY_RIGHT_TYPE_PROPERTY_PUBLIC_FACILITY = 16;
    public static final Integer PROPERTY_RIGHT_TYPE_PROPERTY_SERVICE = 17;
    public static final Integer PROPERTY_RIGHT_TYPE_SOCIAL_SERVICE = 18;
    public static final Integer PROPERTY_RIGHT_TYPE_CARPORT = 19;
    public static final Integer PROPERTY_RIGHT_TYPE_CARPORT_PLACE = 20;
    public static final Integer PROPERTY_RIGHT_TYPE_BIKE_PORT = 21;
    public static final Integer PROPERTY_RIGHT_TYPE_STORE_ROOM = 22;
    public static final Integer PROPERTY_RIGHT_TYPE_FOREIGN_AFFAIR = 23;
    public static final Integer PROPERTY_RIGHT_TYPE_RELIGION = 24;
    public static final Integer PROPERTY_RIGHT_TYPE_PRISON = 25;
    public static final Integer PROPERTY_RIGHT_TYPE_SECURTY =26;
    public static final Integer PROPERTY_RIGHT_TYPE_SOCIAL_WELFARE = 27;
    public static final Integer PROPERTY_RIGHT_TYPE_OTHERS = 28;
    static {
        propertyRightTypeMap.put(1, "商业");
        propertyRightTypeMap.put(2, "办公");
        propertyRightTypeMap.put(3, "住宅");
        propertyRightTypeMap.put(4, "文物");
        propertyRightTypeMap.put(5, "集体宿舍");
        propertyRightTypeMap.put(6, "工业");
        propertyRightTypeMap.put(7, "公用设施");
        propertyRightTypeMap.put(8, "交通");
        propertyRightTypeMap.put(9, "仓储");
        propertyRightTypeMap.put(10, "信息");
        propertyRightTypeMap.put(11, "教育科研");
        propertyRightTypeMap.put(12, "医疗卫生");
        propertyRightTypeMap.put(13, "文化新闻娱乐体育");
        propertyRightTypeMap.put(14, "园林绿化");
        propertyRightTypeMap.put(15, "军事");
        propertyRightTypeMap.put(16, "物业公共配套");
        propertyRightTypeMap.put(17, "物业服务");
        propertyRightTypeMap.put(18, "社区服务");
        propertyRightTypeMap.put(19, "汽车库");
        propertyRightTypeMap.put(20, "车位");
        propertyRightTypeMap.put(21, "自行车库");
        propertyRightTypeMap.put(22, "储藏室");
        propertyRightTypeMap.put(23, "外事");
        propertyRightTypeMap.put(24, "宗教");
        propertyRightTypeMap.put(25, "监狱");
        propertyRightTypeMap.put(26, "保安");
        propertyRightTypeMap.put(27, "社会福利");
        propertyRightTypeMap.put(28, "其它");
    }



    /**
     * S
     A+
     A
     A-
     B+
     B
     B-
     C+
     C
     C-
     */
    public static final Integer S = 1;
    public static final Integer AP = 2;
    public static final Integer A = 3;
    public static final Integer AD = 4;
    public static final Integer BP = 5;
    public static final Integer B = 6;
    public static final Integer BD = 7;
    public static final Integer CP = 8;
    public static final Integer C = 9;
    public static final Integer CD = 10;

    static{
        houseLevelMap.put(1, "S");
        houseLevelMap.put(2, "A+");
        houseLevelMap.put(3, "A");
        houseLevelMap.put(4, "A-");
        houseLevelMap.put(5, "B+");
        houseLevelMap.put(6, "B");
        houseLevelMap.put(7, "B-");
        houseLevelMap.put(8, "C+");
        houseLevelMap.put(9, "C");
        houseLevelMap.put(10, "C-");
    }

    /**
     * 1-spider
     2-其他网站
     3-大客户
     4-内推
     5-扫楼
     6-合作渠道
     7-自助发布
     8-其他
     */

    private static final Integer SOURCE_SPIDER = 1;
    private static final Integer SOURCE_OTHER_WEB_SITE = 2;
    private static final Integer SOURCE_BIG_CLIENT = 3;
    private static final Integer SOURCE_PUSH = 4;
    private static final Integer SOURCE_SWEEP = 5;
    private static final Integer SOURCE_COOPERATION = 6;
    private static final Integer SOURCE_SELF_HELP = 7;
    private static final Integer SOURCE_OTHERS = 8;

    static {
        sourceMap.put(SOURCE_SPIDER, "spider");
        sourceMap.put(SOURCE_OTHER_WEB_SITE, "其他网站");
        sourceMap.put(SOURCE_BIG_CLIENT, "大客户");
        sourceMap.put(SOURCE_PUSH, "内推");
        sourceMap.put(SOURCE_SWEEP, "扫楼");
        sourceMap.put(SOURCE_COOPERATION, "合作渠道");
        sourceMap.put(SOURCE_SELF_HELP, "自助发布");
        sourceMap.put(SOURCE_OTHERS, "其他");
    }

    /**
     * 1-可出租
     2-可出售
     3-已预定
     4-已成交
     5-失效
     */
    private static final Integer CANRENT_RENT_STATUS = 1;
    private static final Integer CANSOLD_RENT_STATUS = 2;
    private static final Integer BOOKED_RENT_STATUS = 3;
    private static final Integer DONE_RENT_STATUS = 4;
    private static final Integer OUT_OFF_DATE_RENT_STATUS = 5;
    static {
        rentStatusMap.put(CANRENT_RENT_STATUS, "可出租");
        rentStatusMap.put(CANSOLD_RENT_STATUS, "可出售");
        rentStatusMap.put(BOOKED_RENT_STATUS, "");
        rentStatusMap.put(DONE_RENT_STATUS, "已成交");
        rentStatusMap.put(OUT_OFF_DATE_RENT_STATUS, "失效");
    }


}
