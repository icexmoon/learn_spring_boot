package cn.icexmoon.books2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@MapperScan("cn.icexmoon.books2.*.mapper")
@SpringBootApplication
public class Books2Application implements CommandLineRunner {
    //    @Autowired
//    BookMapper bookMapper;
//    @Autowired
//    RoleMapper roleMapper;
//    @Autowired
//    private RoleService roleService;
    @Autowired
    ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(Books2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(bookMapper.getBooks(5));
//        System.out.println(roleMapper.getAll());
//        System.out.println(roleService.getRoleById(1));
//        String str = objectMapper.writeValueAsString(new CouponDTO()
//                .setAmount(1.5)
//                .setAddUserId(1)
//                .setEnoughAmount(50.0)
//                .setExpireTime(LocalDateTime.now())
//                .setType(CouponType.ENOUGH_COUPON));
//        System.out.println(str);
//        CouponDTO parsedCouponDTO = objectMapper.readValue(str, CouponDTO.class);
//        System.out.println(parsedCouponDTO);
        System.out.println(objectMapper.writeValueAsString(LocalDateTime.now()));
//        System.out.println(objectMapper.readValue("2022-10-26 15:49:50",LocalDateTime.class));
        System.out.println(objectMapper.getRegisteredModuleIds());
    }
}
