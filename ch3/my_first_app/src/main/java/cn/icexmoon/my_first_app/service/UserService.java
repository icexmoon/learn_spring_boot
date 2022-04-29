package cn.icexmoon.my_first_app.service;

import cn.icexmoon.my_first_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public long addUser(User user){
        String sql = "INSERT INTO `user` (`name`, `age`) VALUES (?, ?)";
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,user.getName());
                ps.setInt(2, user.getAge());
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public void deleteUser(long id) {
        jdbcTemplate.update("delete from user where id=?", id);
    }

    public List<User> getUsers() {
        List<User> users = jdbcTemplate.query("SELECT `id`,`name`,`age` FROM USER", new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    public User getUser(long id) {
        String sql = String.format("select `id`,`name`,`age` from user where id=%d",id);
        User user;
        try{
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }

    public void updateUser(User user){
        String sql = String.format("UPDATE `user` SET`name`='%s',`age`='%d' WHERE id=%d",user.getName(),user.getAge(),user.getId());
        jdbcTemplate.update(sql);
    }
}
