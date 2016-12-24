package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Created_With erp-common
 * @Author: kris
 * @Email: wubinwu@meituan.com
 * @Date: 16/12/20 上午11:08
 * @Descrition:
 */
public class StringUtils {

    public static final String null2Trim(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * 正则表达式验证,查询(大小写敏感)
     *
     * @param str
     * @param regx 正则表达式
     * @return
     * @author zhaolei
     * @created 2011-4-20
     */
    public static final boolean regexMatch(String str, String regx) {
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
