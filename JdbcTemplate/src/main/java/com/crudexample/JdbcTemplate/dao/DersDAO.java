package com.crudexample.JdbcTemplate.dao;

import com.crudexample.JdbcTemplate.model.Ders;
import com.crudexample.JdbcTemplate.model.Ogrenci;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class DersDAO implements DAO<Ders> {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Ders> list() {
        List<Ders> dersler = new ArrayList<>();
        String sql = "SELECT * FROM \"OBS\".\"DERS\"";
        RowMapper<Ders> rowMapper = new RowMapper<Ders>() {
            @Override
            public Ders mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new Ders(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        };
        dersler = jdbcTemplate.query(sql, rowMapper);
        return dersler;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM \"OBS\".\"DERS\" WHERE \"DERS_ID\" = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Ders is deleted... Id :" + id);
    }

    @Override
    public Ders selectById(int id) {
        // prepstat
        String sql = "SELECT * FROM \"OBS\".\"Ders\" WHERE \"DERS_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Ders>() {
            @Override
            public Ders mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Ders(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        }, id);
    }

    @Override
    public void insert(Ders ders) {
        String sql = "INSERT INTO \"OBS\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (:OGRID, :KONUID)";
        HashMap<String, Object> map = new HashMap<>();
        map.put("OGRID", ders.getOgretmenId());
        map.put("KONUID", ders.getKonuId());
        jdbcTemplate.update(sql, map);
        System.out.println("DersOgrenci is inserted... " + ders.toString());
    }
}
