package cn.icexmoon.books2.user.controller;

import cn.icexmoon.books2.user.dto.RoleQueryDTO;
import cn.icexmoon.books2.user.entity.Role;
import cn.icexmoon.books2.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.controller
 * @ClassName : .java
 * @createTime : 2022/10/8 14:40
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@RestController
@RequestMapping("/user/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Integer id){
        return roleService.getRoleById(id);
    }

    @GetMapping("/all")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/query")
    public List<Role> queryRoles(@RequestBody RoleQueryDTO dto){
        return roleService.queryRoles(dto);
    }
}
