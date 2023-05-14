package cn.icexmoon.demo.books.system.util;

import com.sjcx.ccsp.system.PageRequest;
import com.sjcx.ccsp.system.PageResponse;

import java.util.List;

public class MyListUtil {
    /**
     * 根据PageRequest和list推断出合适的PageResponse
     * 可以利用这个方法对假数据进行分页
     *
     * @param source 原始list
     * @param req    请求分页内容
     * @param pageResponse    响应用的分页
     * @return 分页后的当前页面的list
     */
    public static <T> List<T> paging(List<T> source, PageRequest req, PageResponse pageResponse) {
        int current = req.getCurrent();
        int paging = req.getPaging();
        int size = source.size();
        pageResponse.setPaging(paging);
        if (size % paging == 0) {
            pageResponse.setTotal(size / paging);
        } else {
            pageResponse.setTotal(size / paging + 1);
        }
        pageResponse.setCurrent(current);
        if (current > pageResponse.getTotal()) {
            pageResponse.setCurrent(pageResponse.getTotal());
        }
        List<T> sub = source;
        if (source.size() > paging) {
            int startIndex = (pageResponse.getCurrent() - 1) * paging;
            int endIndex = startIndex + paging;
            if (source.size() < endIndex) {
                endIndex = source.size();
            }
            sub = source.subList(startIndex, endIndex);
        }
        return sub;
    }
}
