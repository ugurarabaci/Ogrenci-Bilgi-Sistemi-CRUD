package com.crudexample.JdbcTemplate.dao;

import com.crudexample.JdbcTemplate.model.DersOgrenci;
import com.crudexample.JdbcTemplate.model.Konu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class KonuDAO implements DAO<Konu> {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Konu> list() {
        List<Konu> konular = new ArrayList<>();
        String sql = "SELECT * FROM \"OBS\".\"KONU\"";
        RowMapper<Konu> rowMapper = new RowMapper<Konu>() {
            @Override
            public Konu mapRow(ResultSet rs, int rowNum) throws SQLException {
                // strategy pattern
                return new Konu(rs.getInt(1), rs.getString(2));
            }
        };
        konular = jdbcTemplate.query(sql, rowMapper);
        return konular;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM \"OBS\".\"KONU\" WHERE \"KONU_ID\" = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Konu is deleted... Id :" + id);
    }

    @Override
    public Konu selectById(int id) {
        // prepstat
        String sql = "SELECT * FROM \"OBS\".\"Ders\" WHERE \"KONU_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Konu>() {
            @Override
            public Konu mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Konu(rs.getInt(1), rs.getString(2));
            }
        }, id);
    }

    @Override
    public void insert(Konu konu) {
        String sql = "INSERT INTO \"OBS\".\"KONU\"(\"KONU_ID\", \"KONU\") VALUES( ?, ?)";
        jdbcTemplate.update(sql, konu.getId(), konu.getKonu());
        System.out.println("Konu is inserted... " + konu.toString());
    }
}
