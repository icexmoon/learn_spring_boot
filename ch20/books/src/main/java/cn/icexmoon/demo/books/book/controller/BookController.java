package cn.icexmoon.demo.books.book.controller;


import cn.icexmoon.demo.books.book.entity.Book;
import cn.icexmoon.demo.books.book.entity.enums.BookType;
import cn.icexmoon.demo.books.book.service.IBookService;
import cn.icexmoon.demo.books.system.page.PageRequest;
import cn.icexmoon.demo.books.system.page.PageResponse;
import cn.icexmoon.demo.books.system.result.IResult;
import cn.icexmoon.demo.books.system.result.IResultArrayList;
import cn.icexmoon.demo.books.system.result.Result;
import cn.icexmoon.demo.books.system.result.ResultException;
import cn.icexmoon.demo.books.system.util.MyStringUtil;
import cn.icexmoon.demo.books.system.util.RegexpUtil;
import cn.icexmoon.demo.books.user.entity.User;
import cn.icexmoon.demo.books.user.service.IUserService;
import cn.icexmoon.demo.books.yesapi.service.IWordCheckService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author icexmoon
 * @since 2022-05-06
 */
@RestController
@RequestMapping("")
@Api(tags = "书籍管理")
@Validated
@Log4j2
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IWordCheckService wordCheckService;
    @Resource
    private RedisTemplate<String, GetPagedBooksVO> redisTemplate;


    @RequiresRoles(value = {"guest", "manager"}, logical = Logical.OR)
    @GetMapping("/book")
    @ApiOperation("获取所有图书列表")
    public List<Book> listAllBooks() {
        Result result = new Result();
        List<Book> books = new IResultArrayList<>();
        books.addAll(bookService.list());
        return books;
    }

    @Data
    private static class AddBookDTO {
        @NotBlank
        @ApiModelProperty(value = "书籍名称", required = true)
        private String name;
        @ApiModelProperty(value = "书籍说明", required = true)
        @NotBlank
        private String desc;
        @ApiModelProperty(value = "书籍类型", required = true)
        @NotNull
        private BookType type;
        @ApiModelProperty("ISBN")
        private String isbn;
        @ApiModelProperty("出版社")
        private String publisher;
    }

    @RequiresRoles("manager")
    @PostMapping("/book/add")
    @ApiOperation("添加书籍")
    public Result addBook(@Validated @RequestBody AddBookDTO dto) {
        //添加图书
        Subject subject = SecurityUtils.getSubject();
        String name = (String) subject.getPrincipal();
        User user = userService.getUserByName(name);
        Book book = new Book();
        book.setUserId(user.getId());
        book.setName(dto.getName());
        //对书籍详情进行敏感词检查
        IWordCheckService.Response response = wordCheckService.doWordCheck(dto.getDesc());
        IWordCheckService.checkSensitiveWords(response);
        book.setDescription(dto.getDesc());
        book.setType(dto.getType());
        book.setExtra(Book.Extra.newInstance(dto.getIsbn(), dto.getPublisher()));
        bookService.save(book);
        return Result.success();
    }

    @PostMapping("/book/form/add")
    @ApiOperation("添加书籍（使用表单）")
    public Result addBookByForm(@NotBlank @RequestParam String name,
                                @NotBlank @RequestParam String desc,
                                @ApiParam("书籍类型") @NotNull @RequestParam BookType type) {
        //添加图书
        Subject subject = SecurityUtils.getSubject();
        String uname = (String) subject.getPrincipal();
        User user = userService.getUserByName(uname);
        Book book = new Book();
        book.setUserId(user.getId());
        book.setName(name);
        book.setDescription(desc);
        book.setType(type);
        bookService.save(book);
        return Result.success();
    }

    @Data
    private static class GetBookInfoVO implements IResult {
        @ApiModelProperty("图书id")
        private Integer id;
        @ApiModelProperty("图书名称")
        private String name;
        @ApiModelProperty(value = "图书介绍", notes = "111")
        private String desc;
        @ApiModelProperty("添加人id")
        private Integer uid;
        @ApiModelProperty(value = "书籍类型")
        private BookType bookType;
        @ApiModelProperty("ISBN")
        private String isbn;
        @ApiModelProperty("出版社")
        private String Publisher;

        public static GetBookInfoVO newInstance(Book book) {
            GetBookInfoVO vo = new GetBookInfoVO();
            vo.setId(book.getId());
            vo.setName(book.getName());
            vo.setDesc(book.getDescription());
            vo.setUid(book.getUserId());
            vo.setBookType(book.getType());
            Book.Extra extra = book.getExtra();
            if (extra != null) {
                vo.setIsbn(extra.getISBN());
                vo.setPublisher(extra.getPublisher());
            }
            return vo;
        }
    }

    @ApiOperation("获取书籍详情")
    @GetMapping("/book/detail/{id}")
    public GetBookInfoVO getBookInfo(@Min(1) @PathVariable Integer id) {
        Book book = bookService.getById(id);
        if (book == null) {
            throw new ResultException(Result.ErrorCode.PARAM_CHECK, String.format("%d不是一个有效的书籍id", id));
        }
        return GetBookInfoVO.newInstance(book);
    }

    @ApiOperation("查询书籍列表")
    @GetMapping("/book/list/query")
    public List<Book> getQueryBooks(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String desc,
                                    @RequestParam(required = false) Integer userId) {
        List<Book> books = new IResultArrayList<>();
        QueryWrapper<Book> qw = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(name)) {
            qw.like("name", name);
        }
        if (!ObjectUtils.isEmpty(desc)) {
            qw.like("description", desc);
        }
        if (userId != null && userId > 0) {
            qw.eq("user_id", userId);
        }
        List<Book> findBooks;
        if (!qw.isEmptyOfWhere()) {
            findBooks = bookService.list(qw);
        } else {
            findBooks = bookService.list();
        }
        books.addAll(findBooks);
        return books;
    }

    @Data
    private static class GetQueryBooksByPostJSONDTO {
        @ApiModelProperty("书籍名称")
        private String name;
        @ApiModelProperty("书籍介绍")
        private String desc;
        @ApiModelProperty("添加书籍人id")
        private Integer userId;
    }

    @ApiOperation("查询书籍列表（POST+JSON方式）")
    @PostMapping("/book/list/query")
    public List<Book> getQueryBooksByPostJSON(@RequestBody GetQueryBooksByPostJSONDTO dto) {
        List<Book> books = new IResultArrayList<>();
        QueryWrapper<Book> qw = new QueryWrapper<>();
        String name = dto.getName();
        if (!ObjectUtils.isEmpty(name)) {
            qw.like("name", name);
        }
        String desc = dto.getDesc();
        if (!ObjectUtils.isEmpty(desc)) {
            qw.like("description", desc);
        }
        Integer userId = dto.getUserId();
        if (userId != null && userId > 0) {
            qw.eq("user_id", userId);
        }
        List<Book> findBooks;
        if (!qw.isEmptyOfWhere()) {
            findBooks = bookService.list(qw);
        } else {
            findBooks = bookService.list();
        }
        books.addAll(findBooks);
        return books;
    }

    @Data
    private static class GetPagedBooksDTO {
        @NotNull
        @Valid
        private PageRequest pageRequest;
    }

    @Data
    private static class GetPagedBooksVO {
        @ApiModelProperty("书籍列表")
        private List<Book> books;
        @ApiModelProperty("分页信息")
        private PageResponse pageResponse;
    }

    @PostMapping("/book/page")
    @ApiOperation("获取分页的书籍列表")
    public GetPagedBooksVO getPagedBooks(@Validated @RequestBody GetPagedBooksDTO dto) {
        final String REDIS_PREFIX = "books.getpagedbooks.";
        String dtoJson = JSON.toJSONString(dto);
        String redisKey = REDIS_PREFIX + MyStringUtil.md5(dtoJson);
        GetPagedBooksVO cachedVO = redisTemplate.opsForValue().get(redisKey);
        if (cachedVO != null) {
            return cachedVO;
        }
        log.info("current:" + dto.getPageRequest().getCurrent());
        log.info("paging:" + dto.getPageRequest().getPaging());
        IPage<Book> pagedBooks = bookService.getPagedBooks(dto.getPageRequest().getPage());
        GetPagedBooksVO vo = new GetPagedBooksVO();
        vo.setBooks(pagedBooks.getRecords());
        vo.setPageResponse(PageResponse.getPageResponse(pagedBooks));
        redisTemplate.opsForValue().set(redisKey, vo, 5, TimeUnit.MINUTES);
        return vo;
    }

    @Data
    private static class AddUserDTO {
        @ApiModelProperty(value = "手机号")
        @Pattern(regexp = RegexpUtil.PHONE, message = RegexpUtil.MSG_PHONE)
        private String phone;
    }

    @ApiOperation("注册账号")
    @PostMapping("/user/add")
    public Result addUser(@Validated @RequestBody AddUserDTO dto) {
        if (dto.getPhone() == null) {
            dto.setPhone("");
        }
        return Result.success();
    }

    @Data
    private static class EnumTestDTO {
        @ApiModelProperty(value = "书籍类型", required = true, allowEmptyValue = false)
        @NotNull
        private BookType type;
    }

    @ApiOperation("测试枚举传递和返回")
    @PostMapping("/enum-test")
    public Result enumTest(@RequestBody EnumTestDTO dto) {
        log.debug("type:" + dto.getType());
        return Result.success(dto.getType());
    }

    @ApiOperation("测试通过路径参数传递枚举")
    @PostMapping("/enum-test2/{type}")
    public Result enumTest2(@ApiParam("书籍类型") @NotNull @PathVariable BookType type) {
        log.debug("type:" + type);
        return Result.success(type);
    }

    @PostMapping("/book/del/{id}")
    public Result delBook(@ApiParam("书籍id") @PathVariable Integer id) {
        bookService.removeById(id);
        return Result.success();
    }
}
