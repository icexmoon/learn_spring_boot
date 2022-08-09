package cn.icexmoon.demo.books.system.util;

import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch14
 * @Package : cn.icexmoon.demo.books.system.util
 * @ClassName : .java
 * @createTime : 2022/8/2 15:38
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyStringUtil {
    /**
     * 将数据进行 MD5 加密，并以16进制字符串格式输出
     *
     * @param data
     * @return
     */
    public static String md5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return Hex.encodeHexString(md.digest(data.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "缺少md5编译器");
        }
    }

    /**
     * 将给定字符串首字母大写并返回
     *
     * @param words 字符串
     * @return 首字母大写的字符串
     */
    public static String upperFirst(String words) {
        if (words == null || words.isEmpty()) {
            return words;
        }
        String newWords = words.substring(0, 1).toUpperCase() + words.substring(1);
        return newWords;
    }

    /**
     * 将给定字符串首字母小写并返回
     *
     * @param words 字符串
     * @return 首字母小写的字符串
     */
    public static String lowerFirst(String words) {
        if (words == null || words.isEmpty()) {
            return words;
        }
        String newWords = words.substring(0, 1).toLowerCase() + words.substring(1);
        return newWords;
    }

    /**
     * 将一个字符串从中编码转换为另一种编码
     *
     * @param source         要转换的字符串
     * @param sourceEncoding 原始编码
     * @param targetEncoding 要转换成的目标编码
     * @return
     */
    public static String convert2OtherEncoding(String source, String sourceEncoding, String targetEncoding) {
        try {
            return new String(source.getBytes(sourceEncoding), targetEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new ResultException(Result.ErrorCode.DEFAULT_ERROR, "转码错误");
        }
    }

    public static String md5(String source, String salt) {
        Md5Hash md5Hash = new Md5Hash(source, salt);
        return md5Hash.toString();
    }

    /**
     * 生成指定长度的随机串
     *
     * @param source 字符字典
     * @param length 长度
     * @return
     */
    public static String genRandomCode(String source, int length) {
        StringBuffer code = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            code.append(source.charAt(random.nextInt(source.length())));
        }
        return code.toString();
    }

    /**
     * 生成指定长度的随机穿（数字和字母组成）
     *
     * @param length
     * @return
     */
    public static String genRandomCode(int length) {
        final String source = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMabcdefghijklmnopqrstuvwxyz";
        return genRandomCode(source, length);
    }
}
