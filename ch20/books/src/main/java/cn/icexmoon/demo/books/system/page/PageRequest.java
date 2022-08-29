package cn.icexmoon.demo.books.system.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.page
 * @ClassName : .java
 * @createTime : 2022/7/31 8:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Data
public class PageRequest {
    @ApiModelProperty("当前页码")
    @Min(1)
    @NotNull
    private Integer current;
    @ApiModelProperty("每页分页数据条数")
    @Min(1)
    @NotNull
    private Integer paging;

    /**
     * 返回PageRequest对应的Page对象
     *
     * @param <T>
     * @return
     */
    public <T> Page<T> getPage() {
        Page<T> page = new Page<>();
        page.setCurrent(current);
        page.setSize(paging);
        return page;
    }
}
