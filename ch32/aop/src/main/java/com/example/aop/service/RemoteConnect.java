package com.example.aop.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : aop
 * @Package : com.example.aop.service.impl
 * @ClassName : .java
 * @createTime : 2023/5/21 10:08
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface RemoteConnect {
    Object getInformationFromRemoteServer(Object[] params);
}
