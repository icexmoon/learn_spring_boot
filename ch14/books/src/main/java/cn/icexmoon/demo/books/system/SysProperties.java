package cn.icexmoon.demo.books.system;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ch14
 * @Package : cn.icexmoon.demo.books.system
 * @ClassName : .java
 * @createTime : 2022/8/2 15:47
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
@Component
public class SysProperties {
    @Value("${server.port}")
    private String port;
    @Value("${books.web.host}")
    private String host;
    @Value("${books.file.upload.path}")
    private String uploadPath;
    @Value("${spring.profiles.active}")
    private String evn;
}
