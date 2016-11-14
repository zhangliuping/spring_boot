package com.aug.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.aug.demo.dao.DemoDao;
import com.aug.demo.model.Demo;

@Repository
public class DemoDaoImpl implements DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Demo insert(Demo demo) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO demo(id, name) VALUES(?, ?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, demo.getId());
                preparedStatement.setString(2, demo.getName());
                return preparedStatement;
            }
        }, keyHolder);
        demo.setId(keyHolder.getKey().intValue());
        return demo;
    }

    @Override
    public void update(Demo existingDemo) {
        jdbcTemplate.update("update demo set name=? where id = ?", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, existingDemo.getName());
                preparedStatement.setInt(2, existingDemo.getId());
            }
        });
    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Demo getById(int demoId) {

        List<Demo> demoList = (List<Demo>) jdbcTemplate.query("SELECT * FROM demo WHERE id = " + demoId,
                new ResultSetExtractor() {
                    @Override
                    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                        List<Demo> demos = new ArrayList();
                        while (rs.next()) {
                            Demo demo = new Demo();
                            demo.setId(rs.getInt("id"));
                            demo.setName(rs.getString("name"));
                            demos.add(demo);
                        }
                        return demos;
                    }
                });
        return !CollectionUtils.isEmpty(demoList) ? demoList.get(0) : null;
    }

    @Override
    public void deleteById(int demoId) {
        jdbcTemplate.update("DELETE FROM demo WHERE id = ?", demoId);
    }

}
