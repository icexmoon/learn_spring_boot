package com.example.aop.service.impl;

import com.example.aop.service.SampleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.service.impl
 * @ClassName : .java
 * @createTime : 2023/5/20 17:14
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class SampleServiceImpl implements SampleService<Integer> {
    @Override
    public void sampleGenericMethod(Integer param) {
        System.out.println("SampleServiceImpl.sampleGenericMethod(%d) is called.".formatted(param));
    }

    @Override
    public void sampleGenericCollectionMethod(Collection<Integer> param) {
        System.out.println("SampleServiceImpl.sampleGenericCollectionMethod(%s) is called".formatted(param));
    }
}
