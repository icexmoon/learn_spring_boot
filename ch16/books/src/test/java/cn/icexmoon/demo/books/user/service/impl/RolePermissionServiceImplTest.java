package cn.icexmoon.demo.books.user.service.impl;

import cn.icexmoon.demo.books.user.entity.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RolePermissionServiceImplTest {
    @Autowired
    private RolePermissionServiceImpl rolePermissionService;

    @Test
    public void getPermissionsByRoleId(){
        List<Permission> permissions = rolePermissionService.getPermissionsByRoleId(1);
        System.out.println(permissions);
    }
}
