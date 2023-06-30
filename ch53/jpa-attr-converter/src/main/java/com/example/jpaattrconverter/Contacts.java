package com.example.jpaattrconverter;

import lombok.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : embed
 * @Package : com.example.embed
 * @ClassName : .java
 * @createTime : 2023/6/30 9:58
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Contacts {
    private String name;
    private String address;
    private String phone;
}
