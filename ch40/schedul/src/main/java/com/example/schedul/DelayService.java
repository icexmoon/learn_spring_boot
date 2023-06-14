package com.example.schedul;

import lombok.Synchronized;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : schedul
 * @Package : com.example.schedul
 * @ClassName : .java
 * @createTime : 2023/6/14 16:29
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Component
public class DelayService {
    private int delaySeconds = 1;

    @Synchronized
    public int getDelaySeconds() {
        int delaySeconds = this.delaySeconds;
        if (this.delaySeconds <= 1) {
            this.delaySeconds++;
        } else {
            this.delaySeconds--;
        }
        return delaySeconds;
    }
}
