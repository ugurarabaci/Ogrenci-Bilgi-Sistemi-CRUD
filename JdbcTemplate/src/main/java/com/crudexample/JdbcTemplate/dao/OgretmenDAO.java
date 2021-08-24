package com.crudexample.JdbcTemplate.dao;


import com.crudexample.JdbcTemplate.model.Konu;
import com.crudexample.JdbcTemplate.model.Ogretmen;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OgretmenDAO implements DAO<Ogretmen> {


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public OgretmenDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Ogretmen> list() {
        List<Ogretmen> ogretmenler = new ArrayList<>();
        String sql = "SELECT * FROM \"OBS\".\"OGRETMEN\"";
        RowMapper<Ogretmen> rowMapper = new RowMapper<Ogretmen>() {
            @Override
            public Ogretmen mapRow(ResultSet rs, int rowNum) throws SQLException {
                // strategy pattern
                return new Ogretmen(rs.getInt(1), rs.getString(2));
            }
        };
        ogretmenler = jdbcTemplate.query(sql, rowMapper);
        return ogretmenler;
    }

    @Override
    public void deleteById(int id)    {
        String sql = "DELETE FROM \"OBS\".\"OGRETMEN\" WHERE \"OGR_ID\" = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Ogretmen is deleted... Id :" + id);
    }

    @Override
    public Ogretmen selectById(int id) {
        // prepstat
        String sql = "SELECT * FROM \"OBS\".\"OGRETMEN\" WHERE \"OGR_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Ogretmen>() {
            @Override
            public Ogretmen mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Ogretmen(rs.getInt(1), rs.getString(2));
            }
        }, id);
    }

    @Override
    public void insert(Ogretmen ogretmen) {
        String sql = "INSERT INTO \"OBS\".\"OGRETMEN\"(\"OGR_ID\", \"OGR_NAME\") VALUES (?, ?)";
        jdbcTemplate.update(sql, ogretmen.getId(), ogretmen.getName());
        System.out.println("Ogretmen is inserted... " + ogretmen.toString());
    }
}
