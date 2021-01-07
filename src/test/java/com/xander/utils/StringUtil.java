package com.xander.utils;

import org.thymeleaf.util.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by zhaobing04 on 2020/9/23.
 */
public class StringUtil {

    /**
     * 判断字符是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmoji(String str) throws PatternSyntaxException {
        String regEx = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean isMobileNO(String mobiles) {
//        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0|2]|[5-9]))\\d{8}$";//更加严格的规则，但是虚拟号段的号码一律不支持
        //String regex = "[1][34578]\\d{9}";//宽松一些的规则，过滤随便填写的号码
        String regex = "\\d{11}";//宽松一些的规则，过滤随便填写的号码
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    public static boolean isLength(String str) throws PatternSyntaxException {
        if (StringUtil.isNotEmpty(str)) {
            int length = str.length();
            if (length >= 3 && length <= 21) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
