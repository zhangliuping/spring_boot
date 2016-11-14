package com.aug.demo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.aug.demo.dao.UserDao;
import com.aug.demo.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User insert(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(
                        "INSERT INTO user(name, password, email, age, gender, create_time) VALUES(?, ?, ?, ?, ?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setInt(4, user.getAge());
                preparedStatement.setString(5, user.getGender());
                preparedStatement.setDate(6, new Date(user.getCreateTime().getTime()));
                return preparedStatement;
            }
        }, keyHolder);
        user.setId(keyHolder.getKey().intValue());
        return user;
    }

    @Override
    public User update(User user) {
        // TODO
        return null;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = " + id + "", User.class);
    }

    @Override
    public int deleteById(int userId) {
        return jdbcTemplate.update("DELETE FROM user WHERE id = ?", userId);
    }

    @Override
    public int deleteAllUsers() {
        return jdbcTemplate.update("DELETE FROM user");
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.queryForList("SELECT * FROM user", User.class);
    }

    @Override
    public int deleteByName(String name) {
        return jdbcTemplate.update("DELETE FROM user WHERE name = ?", name);
    }

}
