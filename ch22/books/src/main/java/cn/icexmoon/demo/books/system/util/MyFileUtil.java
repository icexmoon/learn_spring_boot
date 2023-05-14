package cn.icexmoon.demo.books.system.util;

import org.springframework.stereotype.Component;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch14
 * @Package : cn.icexmoon.demo.books.system.util
 * @ClassName : .java
 * @createTime : 2022/8/2 15:36
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class MyFileUtil {
    private MimetypesFileTypeMap mtftp;


    public MyFileUtil() {
        mtftp = new MimetypesFileTypeMap();
        /* 不添加下面的类型会造成误判 详见：http://stackoverflow.com/questions/4855627/java-mimetypesfiletypemap-always-returning-application-octet-stream-on-android-e*/
        mtftp.addMimeTypes("image png tif jpg jpeg bmp");
    }

    public boolean isImage(File file) {
        //检查后缀名是否是图片
        String mimetype = mtftp.getContentType(file);
        String type = mimetype.split("/")[0];
        if (!type.equals("image")) {
            return false;
        }
        //检查文件内容是否为图片（能否正常获取到高和宽）
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            if (bufferedImage == null) {
                return false;
            }
            bufferedImage.getHeight();
            bufferedImage.getWidth();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    public String getFileSuffix(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }
        int potIndex = fileName.lastIndexOf('.');
        if (potIndex < 0) {
            return "";
        }
        if (fileName.length() <= potIndex + 1) {
            return "";
        }
        String suffix = fileName.substring(potIndex + 1);
        return suffix;
    }
}