package cn.icexmoon.books2.common.mapper;

import cn.icexmoon.books2.common.entity.Tmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.common.mapper
 * @ClassName : .java
 * @createTime : 2022/10/22 17:27
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public interface TmpMapper {
    void addTmp(@Param("tmp") Tmp tmp);

    List<Tmp> getAllTmps();
}
