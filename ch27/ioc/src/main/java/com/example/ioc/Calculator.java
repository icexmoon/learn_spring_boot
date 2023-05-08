package com.example.ioc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc
 * @ClassName : .java
 * @createTime : 2023/5/5 10:59
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 一个简单的计算器
 */
@Component
@Scope(ScopeValue.PROTOTYPE)
public class Calculator {
    private double result = 0;

    public double add(double num) {
        return result += num;
    }

    public double subtract(double num) {
        return result -= num;
    }

    /**
     * 重置计算器
     *
     * @return
     */
    public double reset() {
        result = 0;
        return result;
    }

    /**
     * 返回当前计算器运算结果
     *
     * @return
     */
    public double print() {
        return result;
    }

    public double multiply(double num) {
        return result *= num;
    }

    public void construct(){

    }

    public void destroy(){

    }
}
