package models.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created_With kitchen
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/21 上午1:10
 * @Descrition:
 */
public class ContactEnums {

    public static Map<Integer, String> contactMap = new HashMap<>();

    private static final Integer OWNER_CONTACT = 1;
    private static final Integer AGANCY_CONTACT = 2;
    private static final Integer BUSINESS_CONTACT = 3;
    private static final Integer ESTATE_CONTACT = 4;
    private static final Integer OTHERS_CONTACT = 5;
    static {
        contactMap.put(OWNER_CONTACT, "业主");
        contactMap.put(AGANCY_CONTACT, "中介");
        contactMap.put(BUSINESS_CONTACT, "商户");
        contactMap.put(ESTATE_CONTACT, "物业");
        contactMap.put(OTHERS_CONTACT, "其它");
    }

}
