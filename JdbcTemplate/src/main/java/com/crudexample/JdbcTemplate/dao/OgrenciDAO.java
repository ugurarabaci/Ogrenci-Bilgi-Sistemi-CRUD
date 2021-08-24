package com.crudexample.JdbcTemplate.dao;


import com.crudexample.JdbcTemplate.model.Ogrenci;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OgrenciDAO implements DAO<Ogrenci> {


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public OgrenciDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ogrenci> list() {
        List<Ogrenci> ogrenciler = new ArrayList<>();
        String sql = "SELECT * FROM \"OBS\".\"OGRENCI\"";
        RowMapper<Ogrenci> rowMapper = new RowMapper<Ogrenci>() {
            @Override
            public Ogrenci mapRow(ResultSet rs, int rowNum) throws SQLException {
                // strategy pattern
                return new Ogrenci(rs.getInt(1), rs.getInt(2), rs.getString(3));
            }
        };
        ogrenciler = jdbcTemplate.query(sql, rowMapper);
        return ogrenciler;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM \"OBS\".\"OGRENCI\" WHERE \"OGR_ID\" = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Ogrenci is deleted... Id :" + id);
    }

    @Override
    public void insert(Ogrenci ogrenci) {
        String sql = "INSERT INTO \"OBS\".\"OGRENCI\"(\"OGR_NUM\", \"OGR_NAME\") VALUES (?, ?)";
        jdbcTemplate.update(sql, ogrenci.getNumber(), ogrenci.getName());
        System.out.println("Ogrenci is inserted... " + ogrenci.toString());

    }

    @Override
    public Ogrenci selectById(int id) {
        // prepstat
        String sql = "SELECT * FROM \"OBS\".\"OGRENCI\" WHERE \"OGR_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Ogrenci>()
        {
            @Override public Ogrenci mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                return new Ogrenci(rs.getInt(1), rs.getInt(2), rs.getString(3));
            }
        }, id);
    }


}
