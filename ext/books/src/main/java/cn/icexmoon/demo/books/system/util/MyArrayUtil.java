package cn.icexmoon.demo.books.system.util;

import org.springframework.util.ObjectUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ccsp-api
 * @Package : com.sjcx.ccsp.system.util
 * @ClassName : MyArrayUtil.java
 * @createTime : 2022/6/29 9:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyArrayUtil {
    /**
     * 返回字符串数组中第一个非空字符串
     *
     * @param arr
     * @return 如果没有，返回null
     */
    public static String getFirstNoEmpty(String[] arr) {
        for (String str : arr) {
            if (!ObjectUtils.isEmpty(str)) {
                return str;
            }
        }
        return null;
    }

    /**
     * 移除字符串数组中的空元素
     *
     * @param arr 字符串数组
     * @return 移除后的字符串数组
     */
    public static String[] removeEmptyElement(String[] arr) {
        List<String> stringList = new LinkedList<>();
        for (String str : arr) {
            if (!ObjectUtils.isEmpty(str)) {
                stringList.add(str);
            }
        }
        String[] strArr = new String[0];
        return stringList.toArray(strArr);
    }
}
