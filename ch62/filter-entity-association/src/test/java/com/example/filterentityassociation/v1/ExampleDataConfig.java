package com.example.filterentityassociation.v1;

import com.example.filterentityassociation.v1.Account;
import com.example.filterentityassociation.v1.Student;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : filter-entity-association
 * @Package : com.example.filterentityassociation
 * @ClassName : .java
 * @createTime : 2023/7/6 9:51
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@TestConfiguration
public class ExampleDataConfig {
    @Bean
    Student student() {
        Student icexmoon = Student.builder()
                .name("icexmoon")
                .build();
        icexmoon.addAccount(account1())
                .addAccount(account2());
        return icexmoon;
    }

    @Bean
    Account account1() {
        return Account.builder()
                .name("admin")
                .password("123456")
                .role(Account.Role.ADMIN)
                .build();
    }

    @Bean
    Account account2() {
        return Account.builder()
                .name("user2")
                .password("11111111")
                .role(Account.Role.MEMBER)
                .build();
    }
}
