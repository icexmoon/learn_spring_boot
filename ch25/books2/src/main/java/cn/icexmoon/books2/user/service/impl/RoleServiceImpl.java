package cn.icexmoon.books2.user.service.impl;

import cn.icexmoon.books2.user.dto.RoleQueryDTO;
import cn.icexmoon.books2.user.entity.Role;
import cn.icexmoon.books2.user.mapper.RoleMapper;
import cn.icexmoon.books2.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.service.impl
 * @ClassName : .java
 * @createTime : 2022/10/8 14:30
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Service
public class RoleServiceImpl implements RoleService {
//    @Autowired
//    private SqlSession sqlSession;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(Integer id) {
//        return sqlSession.selectOne("cn.icexmoon.books2.user.mapper.RoleMapper.getRoleById", id);
        return roleMapper.getRoleById(id);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
//        return sqlSession.selectList("cn.icexmoon.books2.user.mapper.RoleMapper.getAll");
        return roleMapper.getAll();
    }

    @Override
    public List<Role> queryRoles(RoleQueryDTO dto) {
        return roleMapper.queryRoles(dto);
    }
}
