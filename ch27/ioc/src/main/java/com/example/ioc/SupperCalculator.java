package com.example.ioc;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : ioc
 * @Package : com.example.ioc
 * @ClassName : .java
 * @createTime : 2023/5/5 11:05
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 科学计算器
 */
@Component
public class SupperCalculator implements BeanNameAware {
    private double result = 0;
    private final Calculator calculator;

    @Autowired
    public SupperCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public SupperCalculator(Calculator calculator, double result){
        this.calculator = calculator;
        this.result = result;
    }

    /**
     * 次方运算
     *
     * @param num n次方
     * @return
     */
    public double power(double num) {
        if (calculator == null) {
            System.out.println("dependency is not exist");
            //缺少依赖，用数学函数完成计算
            return result = Math.pow(result, num);
        }
        //存在依赖，利用简单计算器累加实现
        System.out.println("dependency is exist");
        calculator.reset();
        if (num < 0) {
            throw new RuntimeException(new OperationNotSupportedException());
        }
        if (num == 0) {
            return result = 1;
        }
        calculator.add(result);
        for (int i = 0; i < num - 1; i++) {
            calculator.multiply(result);
        }
        return result = calculator.print();
    }

    public double reset() {
        return result = 0;
    }

    public double print() {
        return result;
    }

//    @Autowired(required = false)
//    public void setCalculator(Calculator calculator) {
//        this.calculator = calculator;
//    }

    public double add(double num) {
        if (calculator == null) {
            //缺少依赖，直接实现加法
            return result += num;
        }
        //存在依赖，利用简单计算器实现加法
        calculator.reset();
        calculator.add(result);
        calculator.add(num);
        return result = calculator.print();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is get: %s".formatted(name));
    }
}
