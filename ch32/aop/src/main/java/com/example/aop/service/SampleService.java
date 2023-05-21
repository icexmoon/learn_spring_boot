package com.example.aop.service;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.service.impl
 * @ClassName : .java
 * @createTime : 2023/5/20 17:13
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface SampleService<T> {
    void sampleGenericMethod(T param);
    void sampleGenericCollectionMethod(Collection<T> param);
}