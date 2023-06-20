package com.example.factorybean;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : factory-bean
 * @Package : com.example.factorybean
 * @ClassName : .java
 * @createTime : 2023/6/20 15:02
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class Tank {
    public enum Status {PREPAREDNESS, MAINTENANCE, TRAINING}

    public enum Model {T99A, T96, T95, T88, T69}

    private final Model model;
    private final String factory;
    private final int motorizedHours;
    private final Status status;
}
