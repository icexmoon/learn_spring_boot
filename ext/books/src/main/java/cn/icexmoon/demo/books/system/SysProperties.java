package cn.icexmoon.demo.books.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
public class SysProperties {
    @ApiModelProperty("服务器的主机名/域名")
    @Value("${cn.icexmoon.demo.books.host}")
    private String host;
    //微信网站应用的app_id
    @Value("${cn.icexmoon.demo.books.appid}")
    private String weChatAppId;
    //微信网站应用的secret
    @Value("${cn.icexmoon.demo.books.secret}")
    private String weChatSecret;
}
