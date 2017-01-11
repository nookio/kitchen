package models.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/19 下午6:53
 * @Descrition:
 */
public class CredentialEnums {

    //营业执照
    public static Map<Integer, String> businessLicenceMap = new HashMap<>();
    //食品经营许可证
    public static Map<Integer, String> foodLicenceMap = new HashMap<>();
    //消防安全服务许可证
    public static Map<Integer, String> fireLicenceMap = new HashMap<>();
    //发票
    public static Map<Integer, String> invoiceMap = new HashMap<>();

    /**
     * 00-无，不可新办
     * 01-无，可新办
     * 10-有，可使用，不可转让
     * 11-有，可转让
     */

    private static final Integer NO_AND_NO_NEW_BUSINESS_LICENCE = 0;
    private static final Integer NO_BUT_NEW_BUSINESS_LICENCE = 1;
    private static final Integer YES_USE_NOTRANS_BUSINESS_LICENCE = 10;
    private static final Integer YES_TRANS_BUSINESS_LICENCE = 11;

    static {
        businessLicenceMap.put(NO_AND_NO_NEW_BUSINESS_LICENCE, "无，不可新办");
        businessLicenceMap.put(NO_BUT_NEW_BUSINESS_LICENCE, "无，可新办");
        businessLicenceMap.put(YES_USE_NOTRANS_BUSINESS_LICENCE, "有，可使用，不可转让");
        businessLicenceMap.put(YES_TRANS_BUSINESS_LICENCE, "有，可转让");
    }


    /**
     * 00-无，不可新办
     * 01-无，可新办
     * 10-有，可使用，不可转让
     * 11-有，可转让
     */

    private static final Integer NO_AND_NO_NEW_FOOD_LICENCE = 0;
    private static final Integer NO_BUT_NEW_FOOD_LICENCE = 1;
    private static final Integer YES_USE_NOTRANS_FOOD_LICENCE = 10;
    private static final Integer YES_TRANS_FOOD_LICENCE = 11;

    static {
        foodLicenceMap.put(NO_AND_NO_NEW_FOOD_LICENCE, "无，不可新办");
        foodLicenceMap.put(NO_BUT_NEW_FOOD_LICENCE, "无，可新办");
        foodLicenceMap.put(YES_USE_NOTRANS_FOOD_LICENCE, "有，可使用，不可转让");
        foodLicenceMap.put(YES_TRANS_FOOD_LICENCE, "有，可转让");
    }

    /**
     * 00-无，不可新办
     * 01-无，可新办
     * 10-有，可使用，不可转让
     * 11-有，可转让
     */

    private static final Integer NO_AND_NO_NEW_FIRE_LICENCE = 0;
    private static final Integer NO_BUT_NEW_FIRE_LICENCE = 1;
    private static final Integer YES_USE_NOTRANS_FIRE_LICENCE = 10;
    private static final Integer YES_TRANS_FIRE_LICENCE = 11;

    static {
        fireLicenceMap.put(NO_AND_NO_NEW_FIRE_LICENCE, "无，不可新办");
        fireLicenceMap.put(NO_BUT_NEW_FIRE_LICENCE, "无，可新办");
        fireLicenceMap.put(YES_USE_NOTRANS_FIRE_LICENCE, "有，可使用，不可转让");
        fireLicenceMap.put(YES_TRANS_FIRE_LICENCE, "有，可转让");
    }


    /**
     * 0-不可开
     1-可新办
     2-可代开
     */
    private static final Integer NO_INVOICE = 0;
    private static final Integer NEW_INVOICE = 1;
    private static final Integer REPLACE_INVOICE = 10;

    static{
        invoiceMap.put(NO_INVOICE, "不可开");
        invoiceMap.put(NEW_INVOICE, "可新办");
        invoiceMap.put(REPLACE_INVOICE, "可代开");
    }


}
