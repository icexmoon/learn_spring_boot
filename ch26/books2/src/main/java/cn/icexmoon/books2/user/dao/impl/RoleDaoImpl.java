package cn.icexmoon.books2.user.dao.impl;

import cn.icexmoon.books2.user.dao.RoleDao;
import cn.icexmoon.books2.user.entity.Role;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : books2
 * @Package : cn.icexmoon.books2.user.dao.impl
 * @ClassName : .java
 * @createTime : 2022/10/8 14:21
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public Role getRoleById(Integer id) {
        return sqlSession.selectOne("icexmoon.books2.user.mapper.RoleMapper.getRoleById", id);
    }
}
