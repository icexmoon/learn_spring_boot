package cn.icexmoon.books2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.icexmoon.books2.*.mapper")
@SpringBootApplication
public class Books2Application implements CommandLineRunner {
//    @Autowired
//    BookMapper bookMapper;
//    @Autowired
//    RoleMapper roleMapper;
//    @Autowired
//    private RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(Books2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(bookMapper.getBooks(5));
//        System.out.println(roleMapper.getAll());
//        System.out.println(roleService.getRoleById(1));
    }
}
