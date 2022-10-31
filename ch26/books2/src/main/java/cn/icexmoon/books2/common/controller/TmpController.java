package cn.icexmoon.books2.common.controller;

import cn.icexmoon.books2.common.entity.Tmp;
import cn.icexmoon.books2.common.mapper.TmpMapper;
import cn.icexmoon.books2.system.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.common.controller
 * @ClassName : .java
 * @createTime : 2022/10/22 17:33
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("common/tmp")
public class TmpController {
    @Autowired
    private TmpMapper tmpMapper;

    @PostMapping("/add")
    public Result addTmp(@RequestBody Tmp tmp) {
        tmpMapper.addTmp(tmp);
        return Result.success(tmp.getId());
    }

    @GetMapping("/all")
    public Result<List<Tmp>> getAllTmps(){
        return Result.success(tmpMapper.getAllTmps());
    }
}
