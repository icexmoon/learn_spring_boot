package cn.icexmoon.books2.common.controller;

import cn.icexmoon.books2.common.mapper.MathMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.common.mapper
 * @ClassName : .java
 * @createTime : 2022/10/22 12:53
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/common/math")
public class MathController {
    @Autowired
    private MathMapper mathMapper;

    @GetMapping("/pi")
    public Map<String, String> getPi() {
        Map<String, String> res = new HashMap<>();
        for (int i = 0; i < 99; i++) {
            mathMapper.getPi();
        }
        res.put("pi", mathMapper.getPi().toString());
        return res;
    }
}
