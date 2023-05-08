package com.example.ioc.web;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc.web
 * @ClassName : .java
 * @createTime : 2023/5/8 19:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
@Data
public class DataSource {
    private String driverClassName;
    private String url;
}
