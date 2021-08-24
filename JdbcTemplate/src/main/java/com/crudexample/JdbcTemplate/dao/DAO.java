package com.crudexample.JdbcTemplate.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> list();

    void deleteById(int id);

    Object selectById(int id);

    void insert(T t);

}
