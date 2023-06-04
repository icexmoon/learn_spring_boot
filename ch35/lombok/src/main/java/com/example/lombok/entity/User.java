package com.example.lombok.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok
 * @ClassName : .java
 * @createTime : 2023/5/31 10:00
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor(staticName = "of")
public class User {
    private final Long id;
    @NonNull
    private String name;
    @NonNull
    private Boolean isAdmin = false;
    private boolean delFlag;
}
