package cn.icexmoon.demo.books.system.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.util
 * @ClassName : .java
 * @createTime : 2022/7/31 9:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
/**
 * 常用的正则表达式
 */
public class RegexpUtil {
    //大陆地区手机号（允许为空字符串）
    public static final String PHONE = "^(1[3456789]\\d{9}|)$";
    //手机号验证出错的提示信息
    public static final String MSG_PHONE = "不是合法的手机号";
    //大陆地区车牌号
    public static final String PLATE = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DABCEFGHJK]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";
    //姓名(包含译名)
    public static final String REAL_NAME = "^[\u4E00-\u9FA5]{2,10}(·[\u4E00-\u9FA5]{2,10}){0,2}$";
    public static final String PURE_NUMBER = "^\\d+$";
    public static final String IP = "^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$";
    //日期
    public static final String TIME = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
    public static final String DATE = "\\d{4}-\\d{2}-\\d{2}";
    public static final String TIME_NO_SECONDS = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}";
}
