package com.crudexample.JdbcTemplate.dao;

import com.crudexample.JdbcTemplate.model.Ders;
import com.crudexample.JdbcTemplate.model.DersOgrenci;
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
public class DersOgrenciDAO implements DAO<DersOgrenci> {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<DersOgrenci> list() {

        List<DersOgrenci> dersOgrenciler = new ArrayList<>();
        String sql = "SELECT * FROM \"OBS\".\"DERS_OGRENCI\"";
        RowMapper<DersOgrenci> rowMapper = new RowMapper<DersOgrenci>() {
            @Override
            public DersOgrenci mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new DersOgrenci(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        };
        dersOgrenciler = jdbcTemplate.query(sql, rowMapper);
        return dersOgrenciler;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM \"OBS\".\"DERS_OGRENCI\" WHERE \"KAYIT_ID\" = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Kayıt is deleted... Id :" + id);
    }

    @Override
    public DersOgrenci selectById(int id) {
        // prepstat
        String sql = "SELECT * FROM \"OBS\".\"Ders\" WHERE \"KAYIT_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<DersOgrenci>() {
            @Override
            public DersOgrenci mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new DersOgrenci(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        }, id);
    }

    @Override
    public void insert(DersOgrenci dersOgrenci) {
        String sql = "INSERT INTO \"OBS\".\"DERS_OGRENCI\"(\"OGRENCI_ID\", \"DERS_ID\") VALUES (:OGR_ID, :DERS_ID);";
        HashMap<String, Object> map = new HashMap<>();
        map.put("OGR_ID", dersOgrenci.getOgrenciId());
        map.put("DERS_ID", dersOgrenci.getDersId());
        jdbcTemplate.update(sql, map);
        System.out.println("DersOgrenci is inserted... " + dersOgrenci.toString());
    }
}
