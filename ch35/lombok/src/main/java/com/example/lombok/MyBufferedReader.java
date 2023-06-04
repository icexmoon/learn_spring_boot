package com.example.lombok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : lombok
 * @Package : com.example.lombok
 * @ClassName : .java
 * @createTime : 2023/5/30 18:43
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class MyBufferedReader {
    private BufferedReader bufferedReader;

    public MyBufferedReader(Reader reader) {
        bufferedReader = new BufferedReader(reader);
    }

    public void destroy() throws IOException {
        throw new RuntimeException("destory is called");
//        bufferedReader.close();
    }

    public String readLine() throws IOException {
        throw new RuntimeException("readLine is called");
//        return bufferedReader.readLine();
    }
}
