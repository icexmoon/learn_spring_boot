package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.user.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleSericeImplTest {
    @Autowired
    private RoleServiceImpl roleService;

    @Test
    public void getRoleById() {
        Role role= roleService.getRoleById(1);
    }
}
