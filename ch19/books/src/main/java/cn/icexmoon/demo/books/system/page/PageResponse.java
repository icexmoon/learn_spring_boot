package cn.icexmoon.demo.books.system.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books
 * @Package : cn.icexmoon.demo.books.system.page
 * @ClassName : .java
 * @createTime : 2022/8/8 10:09
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description : 分页用的返回实体
 */
@Data
public class PageResponse {
    @ApiModelProperty("总页数")
    private Long total;
    @ApiModelProperty("当前页数")
    private Long current;
    @ApiModelProperty("用于分页的数据行数")
    private Long paging;
    @ApiModelProperty("总数据条数")
    private Long totalRecords;

    /**
     * 根据IPage获取PageResponse
     *
     * @param ipage
     * @return
     */
    public static PageResponse getPageResponse(IPage ipage) {
        PageResponse pageResponse = new PageResponse();
        pageResponse.setTotal(ipage.getPages());
        pageResponse.setCurrent(ipage.getCurrent());
        pageResponse.setPaging(ipage.getSize());
        pageResponse.setTotalRecords(ipage.getTotal());
        return pageResponse;
    }
}
